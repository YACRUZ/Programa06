/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author yahir
 */
public class DAOVenta implements IDAOGeneral<Venta, Long> {

    @Override
    public Venta create(Venta p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();

        session.save(p);
        for (Iterator<DetalleVenta> iterator = p.getDetalleventa().iterator(); iterator.hasNext();) {
            session.save(iterator.next());           
        }

        t.commit();
        session.close();
        return p;

    }

    @Override
    public boolean delete(Long  id) {
        boolean b;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Venta venta = findById(id);
        if (venta != null){
            session.delete(venta);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se elimino Venta");
            b=true;
        }else{
            b=false;
        }
        
        t.commit();
        session.close();
        return b;
    }

    @Override
    public Venta update(Venta v, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        
        Venta venta = findById(id);
        if (venta != null){
            session.update(venta);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se actualizo Venta");
        }

        t.commit();
        session.close();
        return venta;

    }

    @Override
    public List<Venta> findAll() {
        List<Venta> listaempleados=null;
        
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        listaempleados = session.createQuery("FROM venta").list();
        t.commit();
        session.close();
        return listaempleados;
    }

    @Override
    public Venta findById(Long id) {
        Venta empleado=null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        empleado = session.get(Venta.class, id);
        
        t.commit();
        session.close();
        return empleado;
    }

}
