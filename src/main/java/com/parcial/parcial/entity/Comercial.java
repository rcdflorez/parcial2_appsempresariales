package com.parcial.parcial.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comerciales")
public class Comercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;
    @Column(name = "apellido2", nullable = false, length = 50)
    private String apellido2;
    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;
    @Column(name = "comision", nullable = false)
    private Double comision;

    @OneToMany(mappedBy = "comercial")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Comercial() {
    }

    public Comercial(Long id, String nombre, String apellido1, String apellido2, String ciudad, Double comision, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.comision = comision;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public int getnumeroPeridos(){
        return getPedidos().size();
    }
}
