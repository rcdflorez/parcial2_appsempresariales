package com.parcial.parcial.controller;

import com.parcial.parcial.entity.Comercial;
import com.parcial.parcial.service.comercial.ComercialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComercialControlador {

    @Autowired
    private ComercialServicio servicio;

    @GetMapping({ "/comerciales"})
    public String listarComerciales(Model modelo) {
        modelo.addAttribute("comerciales", servicio.listarTodosLosComercios());
        return "comerciales";
    }

    @GetMapping("/comerciales/nuevo")
    public String mostrarFormularioDeRegistrtarComercial(Model modelo) {
        System.out.println("creando nuevo pedido:");
        Comercial comercial = new Comercial();
        modelo.addAttribute("comercial", comercial);
        return "crear_comercial";
    }

    @PostMapping("/comerciales")
    public String guardarComercial(@ModelAttribute("comercial") Comercial comercial) {
        servicio.guardarComercial(comercial);
        return "redirect:/comerciales";
    }

    @GetMapping("/comerciales/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") Long id, Model modelo) {
        Comercial comercial = (Comercial) servicio.obtenerComercialPorId(id);
        System.out.println(id);
        System.out.println(comercial.getNombre());
        modelo.addAttribute("comercial", comercial);
        return "editar_comercial";
    }

    @PostMapping("/comerciales/{id}")
    public String actualizarComercial(@PathVariable Long id, @ModelAttribute("comercial") Comercial comercial, Model modelo) {
        Comercial comercialExistente = (Comercial) servicio.obtenerComercialPorId(id);
        if(comercialExistente != null){
            comercialExistente.setNombre(comercial.getNombre());
            comercialExistente.setApellido1(comercial.getApellido1());
            comercialExistente.setApellido2(comercial.getApellido2());
            comercialExistente.setCiudad(comercial.getCiudad());
            comercialExistente.setComision(comercial.getComision());

            servicio.guardarComercial(comercialExistente);
            return "redirect:/comerciales";
        }else {
            return "id no encontrado";
        }

    }

    @GetMapping("/comerciales/{id}")
    public String eliminarComercial(@PathVariable Long id) {
        servicio.eliminarComercial(id);
        return "redirect:/comerciales";
    }

}
