/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Yahir jesus
 */
@Entity
@Table(name="venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="clave")
    private int clave;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="monto")
    private double monto;
    
    @OneToMany(mappedBy = "venta")
    private Set<DetalleVenta> detalleventa;
    
    public Venta() {
        detalleventa=new HashSet<>();
    }

    public Set<DetalleVenta> getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(Set<DetalleVenta> detalleventa) {
        this.detalleventa = detalleventa;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
