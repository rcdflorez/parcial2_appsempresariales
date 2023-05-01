package com.parcial.parcial.controller;

import com.parcial.parcial.entity.Pedido;
import com.parcial.parcial.service.Pedido.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidoControlador {

    @Autowired
    private PedidoServicio servicio;

    @GetMapping({ "/pedidos"})
    public String listarPedidos(Model modelo) {
        modelo.addAttribute("pedidos", servicio.listarTodosLosPedidos());
        return "pedidos";
    }

    @GetMapping("/pedidos/nuevo")
    public String mostrarFormularioDeRegistrtarPedido(Model modelo) {
        Pedido pedido = new Pedido();
        modelo.addAttribute("pedido", pedido);
        return "crear_pedido";
    }

    @PostMapping("/pedidos")
    public String guardarPedidos(@ModelAttribute("pedido") Pedido pedido) {
        servicio.guardarPedido(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/pedido/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable("id") Long id, Model modelo) {
        Pedido pedido = (Pedido) servicio.obtenerPedidoPorId(id);
        System.out.println(pedido.getFecha());
        modelo.addAttribute("pedido", pedido);
        return "editar_pedido";
    }

    @PostMapping("/pedidos/{id}")
    public String actualizarPedido(@PathVariable Long id, @ModelAttribute("pedido") Pedido pedido, Model modelo) {
        Pedido pedidoExistente = (Pedido) servicio.obtenerPedidoPorId(id);
        if(pedidoExistente != null){
            pedidoExistente.setCantidad(pedido.getCantidad());

            servicio.guardarPedido(pedidoExistente);
            return "redirect:/pedidos";
        }else {
            return "id no encontrado";
        }
    }

    @GetMapping("/pedidos/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        servicio.eliminarPedido(id);
        return "redirect:/pedidos";
    }

}
