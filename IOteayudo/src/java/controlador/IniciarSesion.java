/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import logic.IniciarSesionHelper;


/**
 *
 * @author yosh
 */
@ManagedBean // LEER LA DOCUMENTACIÖN DE ESTA ANOTACIÓN: Permite dar de alta al bean en la aplicación
@RequestScoped 
public class IniciarSesion {
    private String correo;
    
    private String contrasenia;
    
    private final HttpServletRequest httpServletRequest; // Obtiene información de todas las peticiones de usuario.
    private final FacesContext faceContext; // Obtiene información de la aplicación
    private FacesMessage message; // Permite el envio de mensajes entre el bean y la vista
    private IniciarSesionHelper helper;

    public IniciarSesion(HttpServletRequest httpServletRequest, FacesContext faceContext) {
        this.httpServletRequest = httpServletRequest;
        this.faceContext = faceContext;
    }

    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
   public String iniciarSesion(String correo, String contrasenia) {
       modelo.Usuario login = helper.getLoginPorNombre(correo);
        if (login != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(contrasenia.getBytes());
                byte[] digest = md.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                if (sb.toString().equals(login.getContraseniaUsuario())) {
                    httpServletRequest.getSession().setAttribute("sessionUsuario", correo);
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acceso Correcto", null);
                    faceContext.addMessage(null, message);
                    return "acceso";
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto", null);
            faceContext.addMessage(null, message);
            return "index";
        }
        return "index";
    }

    
    
}
