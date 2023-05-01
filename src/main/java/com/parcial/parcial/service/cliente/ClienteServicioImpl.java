package com.parcial.parcial.service.cliente;


import com.parcial.parcial.entity.Cliente;
import com.parcial.parcial.repositorie.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {
    @Autowired
    private ClienteRepositorio repositorio;

    @Override
    public List<Cliente> listarTodosLosClientes() {
        return repositorio.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        // TODO Auto-generated method stub
        Optional<Cliente> clienteOptional = repositorio.findById(id);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("No se encontró el cliente con id " + id);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        return repositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        // TODO Auto-generated method stub
        repositorio.deleteAllById(Collections.singleton(id));
    }

    @Override
    public List<Cliente>obtenerClientesYPedidos(){
        return repositorio.findAllClientesWithPedidos();
    }

}
