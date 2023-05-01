package com.parcial.parcial.repositorie;

import com.parcial.parcial.entity.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercialRepositorio extends JpaRepository<Comercial, Long> {
}
