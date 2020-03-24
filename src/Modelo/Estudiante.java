/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author santi
 */
public class Estudiante 
{
    
    private int posicion;
    private double nota; 

    public Estudiante() {
        
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Estudiante(int posicion, double nota) {
        this.posicion = posicion;
        this.nota = nota;
    }
    
    public void modificarNota(int posicion,double nota)
    {
        if(posicion==this.posicion)
        {
        this.setNota(nota);
        }
    
    }
    
    public double buscarPorPosicion(int posicion)
    {
        
        if(posicion==this.posicion)
        {
        return nota;
        
        }else{
        
        return 0.0;
        }
    
    }
    
}
