package logica;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    public void registra(int id, String correo, String nombre, String apellidoPa, String apellidoMa, String contrasenia){
       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       Usuario usuario = new Usuario();
       
       usuario.setIdUsuario(id);
       usuario.setCorreoUsuario(correo);
       usuario.setNombreUsuario(nombre);
       usuario.setApellidoPaternoUsuario(apellidoPa);
       usuario.setApellidoMaternoUsuario(apellidoMa);
       usuario.setContraseniaUsuario(contrasenia);
       usuario.setTelefonoUsuario(0);
       usuario.setAcercaDeUsuario("a");
       session.persist(usuario);
       session.getTransaction().commit();
       //session.save(usuario);
       
        //Commit the transaction
       //session.getTransaction().commit();
       //HibernateUtil.shutdown();
    }
}
