package clases;

import java.util.ArrayList;

public class Repertorio {
    
    ArrayList<Persona> r = new ArrayList<>();
    
    public void registrarPersona(Persona p){
        r.add(p);
    }
    
    public ArrayList<Persona> getRepertorio(){
        return r;
    }
}
