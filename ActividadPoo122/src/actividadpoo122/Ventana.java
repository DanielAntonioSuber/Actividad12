package actividadpoo122;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame implements ActionListener {

    JButton boton[] = new JButton[4];
    FuncionesArchivo archivo = new FuncionesArchivo();
   
    public Ventana() {
        archivo.leerArchivo();
        configVentana();
        componentes();
    }

    private void configVentana() {
        setLayout(null);
        setSize(800, 60);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Actividad 12 poo");
        setResizable(false);
    }

    private void componentes() {
        String nombreBoton[] = {"Agregar estudiante", "Agregar profesor", "Consultar estudiante", "consultar profesor"};
        int x = 0;
        for (int i = 0; i < 4; i++) {
            boton[i] = new JButton(nombreBoton[i]);
            boton[i].setBounds(x, 0, 200, 30);
            boton[i].addActionListener(this);
            add(boton[i]);
            x += 200;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Agregar estudiante")) {
            archivo.guardarEstudiante();
        } else if (ae.getActionCommand().equals("Agregar profesor")) {
            archivo.guadarProfesor();
        } else if (ae.getActionCommand().equals("Consultar estudiante")) {
            archivo.mostrarEstudiantes();
        } else if (ae.getActionCommand().equals("consultar profesor")) {
            archivo.mostrarProfesores();
        }
    }
}
