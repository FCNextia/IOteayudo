package logica;

import java.util.Date;
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
public class RegistroHelper {

    private Session session;

    public RegistroHelper() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void registraUsuarioAlumno(int id, String correo, String nombre, String apellidoPa, String apellidoMa, String contrasenia){
       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       Usuario usuario = new Usuario();
       Alumno alumno = new Alumno();
       
       usuario.setIdUsuario(id);
       usuario.setCorreoUsuario(correo);
       usuario.setNombreUsuario(nombre);
       usuario.setApellidoPaternoUsuario(apellidoPa);
       usuario.setApellidoMaternoUsuario(apellidoMa);
       usuario.setContraseniaUsuario(contrasenia);
       usuario.setTelefonoUsuario(0);
       usuario.setAcercaDeUsuario("a");
       
       alumno.setIdUsuario(id);
       alumno.setFechaNacimientoAlumno(new Date(1990,5,23));
       
       session.persist(usuario);
       session.persist(alumno);
       session.getTransaction().commit();
       
    }
    
    public void registraUsuarioTutor(int id, String correo, String nombre, String apellidoPa, String apellidoMa, String contrasenia){
       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       Usuario usuario = new Usuario();
       Tutor tutor = new Tutor();
       
       usuario.setIdUsuario(id);
       usuario.setCorreoUsuario(correo);
       usuario.setNombreUsuario(nombre);
       usuario.setApellidoPaternoUsuario(apellidoPa);
       usuario.setApellidoMaternoUsuario(apellidoMa);
       usuario.setContraseniaUsuario(contrasenia);
       usuario.setTelefonoUsuario(0);
       usuario.setAcercaDeUsuario("vacio");
       
       tutor.setIdUsuario(id);
       tutor.setNivelEstudiosTutor("vacio");
       
       session.persist(tutor);
       session.persist(usuario);
       session.getTransaction().commit();
       
    }
}
