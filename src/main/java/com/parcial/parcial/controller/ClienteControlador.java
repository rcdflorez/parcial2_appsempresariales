package com.parcial.parcial.controller;

import com.parcial.parcial.entity.Cliente;
import com.parcial.parcial.service.cliente.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;


    @GetMapping({ "/clientes", "/" })
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", servicio.listarTodosLosClientes());
        return "clientes";
    }

    @GetMapping({ "/clientes/pedidos" })
    public String obtenerClientesYPedidos(Model modelo) {
        modelo.addAttribute("clientes", servicio.obtenerClientesYPedidos());
        return "clientes-pedidos";
    }

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeRegistrtarCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        servicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") Long id, Model modelo) {
        Cliente cliente = (Cliente) servicio.obtenerClientePorId(id);
        System.out.println(id);
        System.out.println(cliente.getNombre());
        modelo.addAttribute("cliente", cliente);
        return "editar_cliente";
    }

    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente, Model modelo) {
        System.out.println("en el metodo");
        Cliente clienteExistente = (Cliente) servicio.obtenerClientePorId(id);
        if(clienteExistente != null){
            //clienteExistente.setId(id);
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido1(cliente.getApellido1());
            clienteExistente.setApellido2(cliente.getApellido2());
            clienteExistente.setCiudad(cliente.getCiudad());
            clienteExistente.setCategoria(cliente.getCategoria());
            clienteExistente.setEmail(cliente.getEmail());

            servicio.guardarCliente(clienteExistente);
            return "redirect:/clientes";
        }else {
            return "id no encontrado";
        }
    }

    @GetMapping("/clientes/{id}")
    public String eliminarComercial(@PathVariable Long id) {
        servicio.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
