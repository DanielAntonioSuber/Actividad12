package actividadpoo122;

import java.io.Serializable;

public class Persona  implements Serializable{
    protected String nombre;
    protected int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
