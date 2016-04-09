/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import controlador.AltaUsuario;
import modelo.Usuario;

/**
 *
 * @author miguel
 */
public class RegistroHelper {

    private Session session;

    public RegistroHelper() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public AltaUsuario registra(int id, String correo, String nombre, String apellidoPa, String apellidoMa, String contrasenia){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        usuario.setCorreoUsuario(correo);
        usuario.setNombreUsuario(nombre);
        usuario.setApellidoPaternoUsuario(apellidoPa);
        usuario.setApellidoMaternoUsuario(apellidoMa);
        usuario.setContraseniaUsuario(contrasenia);
        
        session.save(usuario);
        HibernateUtil.shutdown();
        
        return null;
    }

}
