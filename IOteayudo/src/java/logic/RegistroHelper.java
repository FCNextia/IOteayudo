package logic;

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
       // session.beginTransaction();
    }
}
