package com.parcial.parcial.service.comercial;

import com.parcial.parcial.entity.Comercial;

import java.util.List;

public interface ComercialServicio {

    public List<Comercial> listarTodosLosComercios();

    public Comercial guardarComercial(Comercial comercial);

    public Object obtenerComercialPorId(Long id);

    public Comercial actualizarComercial(Comercial comercial);

    public void eliminarComercial(Long id);

}
