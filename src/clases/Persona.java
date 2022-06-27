package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
    
    private String DNI;
    private String nombres;
    private String apellidos;
    private int edad;
    private int porcentaje;
    private String tieneDiabetes;
    private Date fecha;
    private String urlFoto;

    public Persona(String DNI, String nombres, String apellidos, int edad, int porcentaje, String tieneDiabetes, Date fecha, String urlFoto) {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.porcentaje = porcentaje;
        this.tieneDiabetes = tieneDiabetes;
        this.fecha = fecha;
        this.urlFoto = urlFoto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTieneDiabetes() {
        return tieneDiabetes;
    }

    public void setTieneDiabetes(String tieneDiabetes) {
        this.tieneDiabetes = tieneDiabetes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    
    public String newFecha(){
        return formatter.format(fecha); 
    }
    
    @Override
    public String toString() {
        return DNI + " - " + apellidos + " - " + edad + " - " + porcentaje + "% - " +
                tieneDiabetes + " - " + newFecha();
    }
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
}
