/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notascurso;

import Negocio.Curo;
import Vista.Intefaz1;
import Negocio.Controlador;
/**
 *
 * @author santi
 */
public class NotasCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
       Curo curso=new Curo();
      Intefaz1 inter=new Intefaz1();
      Controlador c=new Controlador(inter,curso);
      
       
       
    }
    
}
