/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author santi
 */
public class Curo {
    
    private int totalEst;
    private double []notas;

    public Curo() {
        notas=new double[totalEst];
        for (int i = 0; i < totalEst; i++)
        {
            notas[i]=0.0;
        }
        
        
    }

        
    public void setTotalEstudiante(int total){
    
    this.totalEst=total;
    }
    public int getTotalEst() {
        return totalEst;
    }

    
    public double getNotaSubN(int posicion)
    {
    return notas[posicion];
    
    }
    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    
    
    public double promedio()
    {
        double promedio=0.0;
        
        for (int i = 0; i < notas.length; i++) {
            promedio+=notas[i];
        }
        
        return promedio/notas.length;
        
    }
    
    public int darCantidadSobrePromedio()
    
    {
    
        int cantidadPromedio=0;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i]>promedio()){
            cantidadPromedio++;
            }
        }
        
    return cantidadPromedio;
    }
    
    
    
    public void  darNotas(int no)
    {
    
        
    
    }
    
    public void cambiarNota(int posicion, double nota){
    
        notas[posicion]=nota;
    }

    @Override
    public String toString() {
        return "Curo{" + "totalEst=" + totalEst + ", notas=" + notas + '}';
    }
    

    
}