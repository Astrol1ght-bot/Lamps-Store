/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import Dato.Archivo;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author kygo
 */

public class BasicMethods {

    Mantenimiento mant = new Mantenimiento();
    Venta venta=new Venta() ;
    
    public void cerrar(ActionEvent e) {
        System.exit(0);
    }

    public void desactivar(ArrayList<JTextField> j) {
        for (int i = 0; i < j.size(); i++) {
            j.get(i).setEnabled(false);
        }
    }

    public JButton CloseButton(JFrame f) {
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        return cerrar;
    }


    public JButton GrabarButton(ArrayList<JTextField> JTexto, String model, Archivo lamp){
        JButton grabar = new JButton("Grabar");
        grabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mant.StartMapping(lamp);
                mant.ModificarLampara(model, lamp, JTexto);
            }
        });
        return grabar;
    }
    
    public JButton ListarButton(Archivo lamp,JTextArea texto){
        JButton listar=new JButton("Listar") ;
        listar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               mant.StartMapping(lamp);
               mant.ListarLamparas(texto);
           }         
        });    
        return listar;
    }
    
    public JButton VenderButton(String model, ArrayList<JTextField> j,JTextArea texto, Configuracion conf, ArrayList<Lampara> lamp, double precio, Archivo arl){
        JButton vender=new JButton("Vender") ;
        vender.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               venta.Vender(model, j,texto,conf,lamp, precio, arl);
           }         
        });    
        return vender;
    }
    
    public JButton AceptarButton(){
        JButton aceptar=new JButton("Aceptar") ;
        aceptar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               
           }         
        });    
        return aceptar;
    }
}
