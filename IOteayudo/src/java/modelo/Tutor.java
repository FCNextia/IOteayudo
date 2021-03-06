package modelo;
// Generated 9/04/2016 10:24:29 AM by Hibernate Tools 4.3.1



/**
 * Tutor generated by hbm2java
 */
public class Tutor implements java.io.Serializable{


     private int idUsuario;
     private Usuario usuario;
     private String nivelEstudiosTutor;
     private TutorMateria tutorMateria;

    public Tutor() {
    }
    
    public Tutor(Usuario usuario){
        this.usuario = usuario;
    }

	
    public Tutor(Usuario usuario, String nivelEstudiosTutor) {
        this.usuario = usuario;
        this.nivelEstudiosTutor = nivelEstudiosTutor;
    }
    public Tutor(Usuario usuario, String nivelEstudiosTutor, TutorMateria tutorMateria) {
       this.usuario = usuario;
       this.nivelEstudiosTutor = nivelEstudiosTutor;
       this.tutorMateria = tutorMateria;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getNivelEstudiosTutor() {
        return this.nivelEstudiosTutor;
    }
    
    public void setNivelEstudiosTutor(String nivelEstudiosTutor) {
        this.nivelEstudiosTutor = nivelEstudiosTutor;
    }
    public TutorMateria getTutorMateria() {
        return this.tutorMateria;
    }
    
    public void setTutorMateria(TutorMateria tutorMateria) {
        this.tutorMateria = tutorMateria;
    }




}


