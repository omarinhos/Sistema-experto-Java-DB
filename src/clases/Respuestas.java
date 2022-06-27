package clases;

import java.util.ArrayList;

public class Respuestas {
    
    ArrayList<String> r = new ArrayList<>();
    
    public void ingresarRespuesta(String s){
        r.add(s);
    }
    
    public ArrayList<String> getRespuestas(){
        return r;
    }
    
    public void editarRespuestas(String x, int pos){
        r.set(pos, x);
    }
    
}
