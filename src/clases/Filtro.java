package clases;

public class Filtro {
    
    private String DNI;
    private String apellidos;
    private String nombres;
    private int edad;
    private String distrito;
    private int porcentaje;
    private String tieneDiabetes;

    public Filtro(String DNI, String apellidos, String nombres, int edad, String distrito, int porcentaje, String tieneDiabetes) {
        this.DNI = DNI;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.edad = edad;
        this.distrito = distrito;
        this.porcentaje = porcentaje;
        this.tieneDiabetes = tieneDiabetes;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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
    
    
}
