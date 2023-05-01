package com.parcial.parcial.service.Pedido;

import com.parcial.parcial.entity.Pedido;
import com.parcial.parcial.repositorie.PedidoRepositorio;
import com.parcial.parcial.service.cliente.ClienteServicio;
import com.parcial.parcial.service.comercial.ComercialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicioImpl implements PedidoServicio{

    @Autowired
    private PedidoRepositorio repositorio;
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private ComercialServicio comercialServicio;

    @Override
    public List<Pedido> listarTodosLosPedidos() {
        return repositorio.findAll();
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        System.out.println("guardando pedido:");
        System.out.println(pedido);
        //Long id_cliente = (Long) clienteServicio.obtenerClientePorId(pedido.getCliente().getId());
        //Long id_comercial = (Long) comercialServicio.obtenerComercialPorId(pedido.getComercial().getId());
        return repositorio.save(pedido);
    }

    @Override
    public Pedido obtenerPedidoPorId(Long id) {
        Optional<Pedido> pedidoOptional = repositorio.findById(id);
        if (pedidoOptional.isPresent()) {
            return pedidoOptional.get();
        } else {
            throw new RuntimeException("No se encontró el pedido con id " + id);
        }
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return repositorio.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        repositorio.deleteAllById(Collections.singleton(id));
    }


}
