package clases;

import java.util.ArrayList;

public class Preguntas {
    
    ArrayList<Respuestas> r = new ArrayList<>();
    
    //carga las respuestas 
    public void ingresarPregunta(Respuestas res){
        r.add(res);
    }
    
    public ArrayList<Respuestas> getPreguntas(){
        return r;
    }
}
