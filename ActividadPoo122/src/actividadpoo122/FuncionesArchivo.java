package actividadpoo122;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionesArchivo implements Serializable {

    ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
    ArrayList<Profesor> listaProfesor = new ArrayList<>();


    public void guardarEstudiante() {
        Estudiante estudiante = new Estudiante();
        try {
            String nombre;
            int edad, boleta;
            nombre = JOptionPane.showInputDialog(null, "Escribe el nombre del estudiante");
            edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe la edad del estudiante"));
            boleta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ecribe la boleta del estudiante"));

            estudiante.setNombre(nombre);
            estudiante.setEdad(edad);
            estudiante.setBoleta(boleta);

            listaEstudiante.add(estudiante);
            guardarArchivo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo agregar al estudiante");
        }

    }

    public void guadarProfesor() {
        Profesor profesor = new Profesor();
        try {
            String nombre, clase;
            int edad;
            nombre = JOptionPane.showInputDialog(null, "Escribe el nombre del profesor");
            edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Escribe la edad del profesor"));
            clase = JOptionPane.showInputDialog(null, "Ecribe la boleta del profesor");

            profesor.setNombre(nombre);
            profesor.setEdad(edad);
            profesor.setClase(clase);

            listaProfesor.add(profesor);
            guardarArchivo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se pudo agregar al profesor");
        }
    }

    public void mostrarEstudiantes() {
        String lista = "";
        int size = listaEstudiante.size();
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                lista += "Estudiante: " + listaEstudiante.get(i).getNombre()
                        + "\nEdad: " + listaEstudiante.get(i).getEdad()
                        + "\nNumero de boleta: " + listaEstudiante.get(i).getBoleta() + "\n"
                        + "==============================================\n";
            }
        } else {
            lista = "no hay registros";
        }

        JOptionPane.showMessageDialog(null, lista);
    }

    public void mostrarProfesores() {
        String lista = "";
        int cuantos = listaProfesor.size();
        if (cuantos != 0) {
            for (int i = 0; i < cuantos; i++) {
                lista += "Profesor: " + listaProfesor.get(i).getNombre()
                        + "\nEdad: " + listaProfesor.get(i).getEdad()
                        + "\nClase: " + listaProfesor.get(i).getClase() + "\n"
                        + "==============================================\n";
            }
        } else {
            lista = "no hay registros";
        }

        JOptionPane.showMessageDialog(null, lista);
    }

    public void leerArchivo() {
        try {
            FileInputStream fis = new FileInputStream("estudiantes.dat");
            ObjectInputStream entrada = new ObjectInputStream(fis);
            listaEstudiante = (ArrayList<Estudiante>) entrada.readObject();
            fis.close();
            entrada.close();

        } catch (IOException | ClassNotFoundException ex) {
        }

        try {
            FileInputStream fis = new FileInputStream("profesores.dat");
            ObjectInputStream entrada = new ObjectInputStream(fis);
            listaProfesor = (ArrayList<Profesor>) entrada.readObject();
            fis.close();
            entrada.close();

        } catch (IOException | ClassNotFoundException ex) {
        }
    }

    public void guardarArchivo() {
        try {

            FileOutputStream fos = new FileOutputStream("estudiantes.dat");
            ObjectOutputStream salida = new ObjectOutputStream(fos);
            salida.writeObject(listaEstudiante);
            fos.close();
            salida.close();

        } catch (IOException ex) {
            System.out.println("error al final");
        }

        try {

            FileOutputStream fos = new FileOutputStream("profesores.dat");
            ObjectOutputStream salida = new ObjectOutputStream(fos);
            salida.writeObject(listaProfesor);
            fos.close();
            salida.close();

        } catch (IOException ex) {
            System.out.println("error al final");
        }
    }

}
