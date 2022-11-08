/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import Dato.Archivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
/**
 *
 * @author Dilan Gomez Toaza
 */
public class ModConfiguracion {
    
    
    Configuracion con;
    public ModConfiguracion(Configuracion configuracion){
        con=configuracion;
    }
    
    public void descuentos(Archivo ar,ArrayList<JTextField> texto){
        double d1=Double.valueOf(texto.get(0).getText());
        con.setPorcentaje1(d1);
        double d2=Double.valueOf(texto.get(1).getText());
        con.setPorcentaje2(d2);
        double d3=Double.valueOf(texto.get(2).getText());
        con.setPorcentaje3(d3);
        double d4=Double.valueOf(texto.get(3).getText());
        con.setPorcentaje4(d4);
        try {
            ar.UpdateConfig(con);
        } catch (IOException ex) {
            Logger.getLogger(ModConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ConfigurarObsequio(String modelo, Archivo ar, ArrayList<JTextField> texto){
        
        String model=modelo;
        con.setModeloObsequiable(model);      
        int min= Integer.valueOf(texto.get(1).getText());
        con.setCantMinGif(min);
        String gif=texto.get(2).getText();
        con.setObsequio(gif);
        try {
            ar.UpdateConfig(con);
        } catch (IOException ex) {
            Logger.getLogger(ModConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ConfigurarOptimaSell( Archivo ar, ArrayList<JTextField> texto){

        int newCant=Integer.parseInt(texto.get(0).getText());
        con.setCantOptima(newCant);
        try {
            ar.UpdateConfig(con);
        } catch (IOException ex) {
            Logger.getLogger(ModConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ConfigurarPremioSor( Archivo ar, ArrayList<JTextField> texto){       
        int client=Integer.valueOf(texto.get(0).getText());
        con.setNumClientSor(client);
        String premio=texto.get(1).getText();
        con.setPremioSor(premio);
        try {
            ar.UpdateConfig(con);
        } catch (IOException ex) {
            Logger.getLogger(ModConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getDescuentos(ArrayList<JTextField> texto){
        texto.get(0).setText(String.valueOf(con.getPorcentaje1()));
        texto.get(1).setText(String.valueOf(con.getPorcentaje2()));
        texto.get(2).setText(String.valueOf(con.getPorcentaje3()));
        texto.get(3).setText(String.valueOf(con.getPorcentaje4()));
    }
    
    public void getObsequio(ArrayList<JTextField>texto){
        texto.get(0).setText(String.valueOf(con.getCantOptima()));
        texto.get(1).setText(String.valueOf(con.getObsequio()));
    }
    
}
