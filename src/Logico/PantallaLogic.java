/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Dilan Gomez Toaza
 */
public final class PantallaLogic extends JFrame {
    Marcos marcos=new Marcos();
    
    
    public PantallaLogic() throws IOException{    
        init();
    }
    
    public void init() throws IOException {     
        this.setBounds(500,200,500, 400);
        mb = new JMenuBar();
        m1 = new JMenu("Archivo");
        m2 = new JMenu("Mantenimiento");
        m3 = new JMenu("Ventas");
        m4 = new JMenu("Configuracion");
        m5 = new JMenu("Ayuda");
        m11 = new JMenuItem("Salir");
        m21 = new JMenuItem("Consultar Lamapara");
        m22 = new JMenuItem("Modificar Lampara");
        m23 = new JMenuItem("Listar Lamaparas");
        m31 = new JMenuItem("Vender");
        m32 = new JMenuItem("Generar reportes");
        m41 = new JMenuItem("Configurar descuentos");
        m42 = new JMenuItem("Configurar obsequio");
        m43 = new JMenuItem("Configurar cantidad optima de lamaparas vendidas");
        m44 = new JMenuItem("Configurar premio sorpresa");
        m51 = new JMenuItem("Acerca de Tienda");

        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        m21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marcos.fConsult();
            }
        });
        m22.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fModificarLamp();
            }
        });
        m23.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fListarLampara();
            }
        });
        m31.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fVender();
            }
        });
        m32.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fGenReport();
            }
        });
        m41.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fConfigurarDescuentos();
            }
        });
        m42.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fConfigurarObsequio();
            }
        });
        m43.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fConfigurarOptimaVendidas();
            }
        });
        m44.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fConfigurarPremioSorpresa();
            }
        });
        m51.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                marcos.fAcercaTienda();
            }
        });
       
        
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        mb.add(m5);
        m1.add(m11);
        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        m3.add(m31);
        m3.add(m32);
        m4.add(m41);
        m4.add(m42);
        m4.add(m43);
        m4.add(m44);
        m5.add(m51);

        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.setVisible(true);
    }
 
    //componentes
    JMenuBar mb;
    JMenu m1;
    JMenu m2;
    JMenu m3;
    JMenu m4;
    JMenu m5;
    JMenuItem m11;
    JMenuItem m21;
    JMenuItem m22;
    JMenuItem m23;
    JMenuItem m31;
    JMenuItem m32;
    JMenuItem m41;
    JMenuItem m42;
    JMenuItem m43;
    JMenuItem m44;
    JMenuItem m51;
}
