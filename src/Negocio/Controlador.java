package Negocio;

import Modelo.Estudiante;
import Vista.Intefaz1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Controlador implements ActionListener {

    Estudiante notas[];
    public Intefaz1 interf = null;
    public Curo curso = null;

    public Controlador(Intefaz1 interf, Curo curso) {
        super();
        this.interf = interf;
        this.curso = curso;
        actionListener(this);
    }

    public Controlador() {

    }

    private void actionListener(ActionListener controlador) {

        interf.btnIngresar.addActionListener(controlador);
        interf.jButton2.addActionListener(controlador);
        interf.jButton4.addActionListener(controlador);
        interf.jButton3.addActionListener(controlador);

    }

    public String recorrerArray() throws Exception {

        String datos = "";

        for (int j = 0; j < notas.length; j++) {
            if (j == 0) {
                datos += "Nombre" + "  [posicion]";
            }
            if (notas[j] == null) {
                throw new Exception("Nota vacia");
            }

            datos += "\n" + "Estudiante   [" + (notas[j].getPosicion() + 1) + "]   " + notas[j].getNota();
        }
        return datos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getActionCommand().contentEquals("Ingresar")) {
                int cantidad = Integer.parseInt(interf.cantiEstudiantes.getText());
                if (cantidad < 0) {
                    try {
                        throw new Exception("no se puede crear");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                notas = new Estudiante[cantidad];
                String datos = "";

                for (int j = 0; j < notas.length; j++) {

                    notas[j] = new Estudiante(j, 0.0);
                    if (j == 0) {
                        datos += "Nombre" + "[posicion]";
                    }
                    datos += "\n" + "Estudiante   [" + (notas[j].getPosicion() + 1) + "]   " + notas[j].getNota();
                }
                interf.jTextArea1.setText(datos);

                interf.btnIngresar.setEnabled(false);

            }
            if (e.getActionCommand().contentEquals("Mostrar Promedio")) {

                double notasEs[] = new double[notas.length];
                int i = 0;
                for (Estudiante es : notas) {
                    notasEs[i] = es.getNota();
                    i++;
                }
                curso.setTotalEstudiante(notas.length);
                curso.setNotas(notasEs);

                interf.jTextArea1.setText("PROMEDIO DEL CURSO\n" + Double.toString(curso.promedio()));

            }
            if (e.getActionCommand().contentEquals("Modificar nota")) {
                int posicion = Integer.parseInt(interf.jtPosicion.getText());
                double nota = Double.parseDouble(interf.jtNota.getText());

                if (nota < 0 || nota > 5) {
                    throw new Exception("Nota invalida");
                }

                for (int i = 0; i < notas.length; i++) {
                    notas[i].modificarNota(posicion - 1, nota);

                }

                interf.jTextArea1.setText(recorrerArray());

            }
            
            
            if(e.getActionCommand().contentEquals("Mostrar las notas"))
            {
            interf.jTextArea1.setText(recorrerArray());
            
            }
            if(e.getActionCommand().contentEquals("Notas mayores a promedio"))
            {
                if(curso.getNotas()==null)
                    throw new Exception ("Notas vacias");
                int cantidad=0;
                String datos="";
                for (int i = 0; i < curso.getNotas().length; i++) 
                {
                    if(curso.getNotaSubN(i)>curso.promedio())
                    {
                        datos+="\n" + "Estudiante   [" + (notas[i].getPosicion() + 1) + "]   " + notas[i].getNota(); 
                        cantidad++;
                    }
                }
                
                if(cantidad==0)
                    datos="Ningun estudiante tiene una nota mayor al promedio";
                
                interf.jTextArea1.setText(datos);
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}
