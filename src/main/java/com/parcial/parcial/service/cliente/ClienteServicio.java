package com.parcial.parcial.service.cliente;



import com.parcial.parcial.entity.Cliente;

import java.util.List;

public interface ClienteServicio {

    public List<Cliente> listarTodosLosClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Object obtenerClientePorId(Long id);

    public Cliente actualizarCliente(Cliente cliente);

    public void eliminarCliente(Long id);

    public List<Cliente> obtenerClientesYPedidos();


}
