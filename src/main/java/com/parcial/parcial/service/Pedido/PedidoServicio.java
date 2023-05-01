package com.parcial.parcial.service.Pedido;

import com.parcial.parcial.entity.Pedido;

import java.util.List;

public interface PedidoServicio {
    public List<Pedido> listarTodosLosPedidos();

    public Pedido guardarPedido(Pedido pedido);

    public Pedido obtenerPedidoPorId(Long id);

    public Pedido actualizarPedido(Pedido pedido);

    public void eliminarPedido(Long id);
}
