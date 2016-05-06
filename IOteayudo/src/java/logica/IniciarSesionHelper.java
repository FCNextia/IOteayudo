/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Alumno;
import modelo.Tutor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelo.Usuario;

/**
 *
 * @author miguel
 */
public class IniciarSesionHelper {

    private Session session;
    private Transaction tx;

    public IniciarSesionHelper() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        tx = session.beginTransaction();
    }

    public Usuario getLoginPorCorreo(String correo) {
        Query q = session.getNamedQuery("BuscaPorCorreo").setString("correoUsuario", correo);
        return (Usuario)q.uniqueResult();
    }
    
    public boolean esAlumno(int id) {
        Query q = session.getNamedQuery("BuscaAlumnoPorID").setInteger("idUsuario", id);
        Alumno a = (Alumno)q.uniqueResult();
        return a != null;
    }
    
    public boolean esTutor(int id) {
        Query q = session.getNamedQuery("BuscaTutorPorID").setInteger("idUsuario", id);
        Tutor t = (Tutor)q.uniqueResult();
        return t != null;
    }
}
