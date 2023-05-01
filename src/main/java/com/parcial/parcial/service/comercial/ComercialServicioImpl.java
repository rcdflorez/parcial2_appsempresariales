package com.parcial.parcial.service.comercial;

import com.parcial.parcial.entity.Comercial;
import com.parcial.parcial.repositorie.ComercialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ComercialServicioImpl implements ComercialServicio {
    @Autowired
    private ComercialRepositorio repositorio;

    @Override
    public List<Comercial> listarTodosLosComercios() {
        return repositorio.findAll();
    }

    @Override
    public Comercial guardarComercial(Comercial comercial) {
        return repositorio.save(comercial);
    }

    @Override
    public Comercial obtenerComercialPorId(Long id) {
        Optional<Comercial> clienteOptional = repositorio.findById(id);
        if (clienteOptional.isPresent()) {
            return clienteOptional.get();
        } else {
            throw new RuntimeException("No se encontró el comercial con id " + id);
        }
    }

    @Override
    public Comercial actualizarComercial(Comercial comercial) {
        return repositorio.save(comercial);
    }

    @Override
    public void eliminarComercial(Long id) {
        repositorio.deleteAllById(Collections.singleton(id));
    }

}
