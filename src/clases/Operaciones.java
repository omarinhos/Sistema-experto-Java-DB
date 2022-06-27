package clases;

public class Operaciones {
    
    //registra la persona en el repertorio
    public void registrarPersona(Repertorio r, Persona p, Preguntas pre){
        r.registrarPersona(p);
    }
    
    //dependiendo de la respueta se asigna el id
    public int setIdRespuesta(String opcion){
        switch (opcion) {
            case "Nunca":
                return 1;
            case "Casi nunca":
                return 2;
            case "En ocasiones":
                return 3;
            case "Con frecuencia":
                return 4;
            case "Casi siempre":
                return 5;
            case "Siempre":
                return 6;
            default:
                break;
        }
        return 0;
    }
    
    private final String[] preguntas; 
    private final String[] frecuencia;

    
    public Operaciones(){
        preguntas = new String[8];
        preguntas[0] = "¿Siente la necesidad exagerada de tomar agua?";
        preguntas[1] = "¿Siente la sensacion incontenible de hambre a pesar de haber comido?";
        preguntas[2] = "¿Siente que la emision de el volumen de orina es superior al esperado?";
        preguntas[3] = "¿Siente que pierde peso rápido a pesar de su hambre constante?";
        preguntas[4] = "¿Con que frecuencia se siente con cansancio?";
        preguntas[5] = "¿Con que frecuencia a sentidos entumecimientos (pies - manos)?";
        preguntas[6] = "¿Con que frecuencia a sentido que su vista esta borrosa?";
        preguntas[7] = "¿Con que frecuencia tiene llagas de curacion lenta?";
        
        frecuencia = new String[6];
        frecuencia[0] = "Nunca";
        frecuencia[1] = "Casi nunca";
        frecuencia[2] = "En ocasiones";
        frecuencia[3] = "Con frecuencia"; 
        frecuencia[4] = "Casi siempre";
        frecuencia[5] = "Siempre";
    }
    
    public String[] getPreguntas(){
        return preguntas;
    }
    
    public String[] getFrecuencia(){
        return frecuencia;
    }
    
}
