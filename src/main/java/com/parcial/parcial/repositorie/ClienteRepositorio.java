package com.parcial.parcial.repositorie;

import com.parcial.parcial.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @Query(value = "SELECT * FROM clientes c ORDER BY c.apellido1, c.apellido2, c.nombre", nativeQuery = true)
    List<Cliente> findAllClientesWithPedidos();
}
