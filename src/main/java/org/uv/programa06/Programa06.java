/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa06;


import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author yahir
 */
public class Programa06 {

    public static void main(String[] args) {
        DAOVenta dao=new DAOVenta();
        Venta venta=new Venta();
        
        Date fecha = Date.from(Instant.now());
        java.sql.Date FechaSQL=new java.sql.Date(fecha.getTime());
        venta.setFecha(FechaSQL);
        
        DetalleVenta detVenta=new DetalleVenta();
        detVenta.setCantidad(10);
        detVenta.setPrecio(20);
        detVenta.setSubtotal(10*20);
        detVenta.setVenta(venta);
        venta.getDetalleventa().add(detVenta);
        
        DetalleVenta detVenta2=new DetalleVenta();
        detVenta2.setCantidad(3);
        detVenta2.setPrecio(10);
        detVenta2.setSubtotal(10*3);
        detVenta2.setVenta(venta);
        venta.getDetalleventa().add(detVenta2);
        
        venta.setMonto(30+200);
        dao.create(venta);
    }
}
