/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import Dato.Archivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kygo
 */
public class Marcos {

    BasicMethods BasicM = new BasicMethods();
    Mantenimiento mant = new Mantenimiento();
    Venta venta = new Venta();
    Archivo lamp = new Archivo();
    Archivo con=new Archivo();
    Configuracion configuracion= con.LeerConfiguracion();

    

    // MARCO DE CONSULTA DE LAMPARAS
    public void fConsult() {
        mant.StartMapping(lamp);

        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Consultar Lampara");
        f.setBounds(x + 30, y + 30, 430, 240);

        //COMBOBOX 
        JComboBox modelos = new JComboBox<String>();
        modelos.addItem("MEDUSA");
        modelos.addItem("KEFREN");
        modelos.addItem("KASK");
        modelos.addItem("HOT");
        modelos.addItem("LAIA");

        //AREAS DE TEXTO
        JTextField Tprecio = new JTextField(10);
        JTextField Tluces = new JTextField(10);
        JTextField Tcolor = new JTextField(10);
        JTextField Tpotencia = new JTextField(10);

        //ARRAY DE AREAS DE TEXTO
        ArrayList<JTextField> JTexto = new ArrayList<>();
        JTexto.add(Tprecio);
        JTexto.add(Tpotencia);
        JTexto.add(Tcolor);
        JTexto.add(Tluces);
        BasicM.desactivar(JTexto);

        String model = (String) modelos.getSelectedItem();

        //BOTONES
        JButton cerrar = BasicM.CloseButton(f);

        //ACCIONES
        modelos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                String model = (String) modelos.getSelectedItem();
                mant.ConsultarLampara(model, JTexto);
            }
        });

        mant.ConsultarLampara(model, JTexto);

        //PANEL DE ETIQUETAS
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5, 3, 5, 5));
        panelPrincipal.add(new JLabel("modelo:  "));
        panelPrincipal.add(modelos);
        panelPrincipal.add(cerrar);
        panelPrincipal.add(new JLabel("Precio(/S):  "));
        panelPrincipal.add(Tprecio);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(new JLabel("Potencia:  "));
        panelPrincipal.add(Tpotencia);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(new JLabel("Color:   "));
        panelPrincipal.add(Tcolor);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(new JLabel("Numero de luces:  "));
        panelPrincipal.add(Tluces);

        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    public void fModificarLamp() {
        mant.StartMapping(lamp);

        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Consultar Lampara");
        f.setBounds(x + 30, y + 30, 430, 240);

        //COMBOBOX 
        JComboBox modelos = new JComboBox<String>();
        modelos.addItem("MEDUSA");
        modelos.addItem("KEFREN");
        modelos.addItem("KASK");
        modelos.addItem("HOT");
        modelos.addItem("LAIA");

        //AREAS DE TEXTO
        JTextField Tprecio = new JTextField(10);
        JTextField Tluces = new JTextField(10);
        JTextField Tcolor = new JTextField(10);
        JTextField Tpotencia = new JTextField(10);

        //ARRAY DE AREAS DE TEXTO
        ArrayList<JTextField> JTexto = new ArrayList<>();
        JTexto.add(Tprecio);
        JTexto.add(Tpotencia);
        JTexto.add(Tcolor);
        JTexto.add(Tluces);

        String model = (String) modelos.getSelectedItem();

        //BOTONES
        JButton cerrar = BasicM.CloseButton(f);
        JButton grabar = BasicM.GrabarButton(JTexto, model, lamp);

        //ACCIONES
        modelos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                String model = (String) modelos.getSelectedItem();
                mant.ConsultarLampara(model, JTexto);
            }
        });

        mant.ConsultarLampara(model, JTexto);

        //PANEL DE ETIQUETAS
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5, 3, 5, 5));
        panelPrincipal.add(new JLabel("modelo:  "));
        panelPrincipal.add(modelos);
        panelPrincipal.add(cerrar);
        panelPrincipal.add(new JLabel("Precio(/S):  "));
        panelPrincipal.add(Tprecio);
        panelPrincipal.add(grabar);
        panelPrincipal.add(new JLabel("Potencia:  "));
        panelPrincipal.add(Tpotencia);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(new JLabel("Color:   "));
        panelPrincipal.add(Tcolor);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(new JLabel("Numero de luces:  "));
        panelPrincipal.add(Tluces);

        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    public void fListarLampara() {
        mant.StartMapping(lamp);

        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Listar lamparas");
        f.setBounds(x + 30, y + 30, 500, 400);

        //CREO AREA TEXTO
        JTextArea texto = new JTextArea();
        texto.setColumns(20);
        texto.setRows(5);
        texto.setEnabled(false);

        //CREO SCROLLPANE
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setViewportView(texto);

        //BOTONES
        JButton cerrar = BasicM.CloseButton(f);
        JButton listar = BasicM.ListarButton(lamp, texto);

        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(5, 5));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelPrincipal.add(scrollpane, BorderLayout.CENTER);

        //CREO PANEL DE BOTONES
        JPanel botonPrincipal = new JPanel();
        botonPrincipal.add(cerrar);
        botonPrincipal.add(listar);

        //ANIADO Y VISIBLE
        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.getContentPane().add(BorderLayout.SOUTH, botonPrincipal);
        f.setVisible(true);
    }

    public void fVender() {
        ArrayList<Lampara> lamparas=new ArrayList<>();
        Configuracion config=new Configuracion();
        try {
            lamparas=lamp.LeerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Marcos.class.getName()).log(Level.SEVERE, null, ex);
        }
        config=con.LeerConfiguracion();
        
        mant.StartMapping(lamp);
        
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Vender");
        f.setBounds(x + 30, y + 30, 500, 400);

        //CREO AREA TEXTO
        JTextArea texto = new JTextArea();
        texto.setColumns(20);
        texto.setRows(5);
        texto.setEnabled(false);

        //CREO SCROLLPANE
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setViewportView(texto);

        //COMBOBOX 
        JComboBox modelos = new JComboBox<String>();
        modelos.addItem("MEDUSA");
        modelos.addItem("KEFREN");
        modelos.addItem("KASK");
        modelos.addItem("HOT");
        modelos.addItem("LAIA");

        //AREAS DE TEXTO PEQUENIAS
        JTextField Tprecio = new JTextField(10);
        Tprecio.setEnabled(false);
        JTextField Tcantidad = new JTextField(10);

        //ARRAY DE AREAS DE TEXTO
        ArrayList<JTextField> JTexto = new ArrayList<>();
        JTexto.add(Tprecio);
        JTexto.add(Tcantidad);
        Tprecio.setText("0");
        String model = (String) modelos.getSelectedItem();

        //BOTONES
        JButton cerrar = BasicM.CloseButton(f);
        

        //FUNCIONES
        modelos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                String model = (String) modelos.getSelectedItem();
                for (int i = 0; i < mant.getArrayList().size(); i++) {
                    if (model.equals(mant.getArrayList().get(i).getModelo())) {
                        Tprecio.setText(String.valueOf(mant.getArrayList().get(i).getPrecio()));
                    }
                }
            }
        });
        JButton vender = BasicM.VenderButton(model, JTexto, texto, config, lamparas, Double.valueOf(Tprecio.getText()), lamp);
        //CREO SCROLL PRINCIPAL
        JPanel scrollPrincipal = new JPanel();
        scrollPrincipal.setLayout(new BorderLayout(5, 5));
        scrollPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPrincipal.add(scrollpane, BorderLayout.CENTER);

        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 3, 5, 5));
        panelPrincipal.add(new JLabel("Modelo"));
        panelPrincipal.add(modelos);
        panelPrincipal.add(vender);
        panelPrincipal.add(new JLabel("Precio(S/)"));
        panelPrincipal.add(Tprecio);
        panelPrincipal.add(cerrar);
        panelPrincipal.add(new JLabel("Cantidad"));
        panelPrincipal.add(Tcantidad);

        //ANIADO Y VISIBLE
        f.getContentPane().add(BorderLayout.CENTER, scrollPrincipal);
        f.getContentPane().add(BorderLayout.PAGE_START, panelPrincipal);
        f.setVisible(true);
    }

    public void fGenReport() {
        mant.StartMapping(lamp);
        
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Generar reportes");
        f.setBounds(x + 30, y + 30, 500, 400);

        //BOTONES
        JButton cerrar = BasicM.CloseButton(f);

        //CREO COMBOBOX
        JComboBox combito = new JComboBox<String>();
        combito.addItem("Ventas por Modelo");
        combito.addItem("Ventas por lampara");
        combito.addItem("Maletas por venta optima");
        combito.addItem("Precio en relacion al promedio");
        combito.addItem("Promedios, maximos y minimos");

        //AREA DE TEXTO
        JTextArea JTexto = new JTextArea();

        //CREO SCROLLPANE
        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setViewportView(JTexto);

        combito.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String reporte = (String) combito.getSelectedItem();
                if (reporte.equals("Ventas por Modelo")) {
                    JTexto.setText(null);
                }
                if (reporte.equals("Ventas por lampara")) {
                    JTexto.setText(null);
                    venta.VentaXLampara(mant.getArrayList(), JTexto, lamp);
                }
                if (reporte.equals("Maletas por venta optima")) {
                    JTexto.setText(null);
                    venta.MaletaVentaOptima(mant.getArrayList(), JTexto, con, lamp);
                }
                if (reporte.equals("Precio en relacion al promedio")) {
                    JTexto.setText(null);
                    venta.PrecioPromedio(mant.getArrayList(), JTexto);
                }
                if (reporte.equals("Promedios, maximos y minimos")) {
                    JTexto.setText(null);
                    venta.PromedioMaxMin(mant.getArrayList(), JTexto);
                }
            }
        });

        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.add(new JLabel("Tipo de Reporte"));
        panelPrincipal.add(combito);
        panelPrincipal.add(cerrar);

        //CREO SCROLL PRINCIPAL
        JPanel scrollPrincipal = new JPanel();
        scrollPrincipal.setLayout(new BorderLayout(5, 5));
        scrollPrincipal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPrincipal.add(scrollpane, BorderLayout.CENTER);

        //ANIDIENDO AL MARCO
        f.getContentPane().add(BorderLayout.CENTER, scrollPrincipal);
        f.getContentPane().add(BorderLayout.PAGE_START, panelPrincipal);
        f.setVisible(true);
    }  
    public void fConfigurarDescuentos() {
        ModConfiguracion modifyCon=new ModConfiguracion(configuracion);
        
        
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Configurar Descuentos");
        f.setBounds(x + 30, y + 30, 500, 200);

        //BOTONES
        JButton cerrar = BasicM.CloseButton(f);
        JButton aceptar = new JButton("Aceptar");

        //CREO AREAS DE TEXTO
        JTextField per1 = new JTextField(10);
        JTextField per2 = new JTextField(10);
        JTextField per3 = new JTextField(10);
        JTextField per4 = new JTextField(10);
        
        ArrayList<JTextField> percs=new ArrayList<>();
        percs.add(per1);
        percs.add(per2);
        percs.add(per3);
        percs.add(per4);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyCon.descuentos(con,percs);
            }
        });
        
        modifyCon.getDescuentos(percs);
        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4, 3, 20, 5));
        panelPrincipal.add(new JLabel("1 a 5 lamparas"));
        panelPrincipal.add(per1);
        panelPrincipal.add(cerrar);
        panelPrincipal.add(new JLabel("6 a 10 lamparas"));
        panelPrincipal.add(per2);
        panelPrincipal.add(aceptar);
        panelPrincipal.add(new JLabel("11 a 15 lamparas"));
        panelPrincipal.add(per3);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(new JLabel("Mas de 15 lamparas"));
        panelPrincipal.add(per4);

        //ANIADO AL MARCO
        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    public void fConfigurarObsequio() {
        ModConfiguracion modifyCon=new ModConfiguracion(configuracion);
        
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Configurar Obsequio");
        f.setBounds(x + 30, y + 30, 600, 150);

        //CREO COMBOBOX
        JComboBox modelos = new JComboBox<String>();
        modelos.addItem("MEDUSA");
        modelos.addItem("KEFREN");
        modelos.addItem("KASK");
        modelos.addItem("HOT");
        modelos.addItem("LAIA");
        
        
        //BOTONES
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        //CREO AREAS DE TEXTO
        JTextField cantM = new JTextField(10);
        JTextField obsequio = new JTextField(10);
        
        ArrayList<JTextField> Jtexto=new ArrayList<>();
        Jtexto.add(cantM);
        Jtexto.add(obsequio);
        
        
        String model=modelos.getSelectedItem().toString();
        
        modelos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                modifyCon.getObsequio(Jtexto);
                
            }
        });
              
        
        
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                modifyCon.ConfigurarObsequio(model, con,Jtexto );
            }
        });
        
        
        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 3, 5, 5));
        panelPrincipal.add(new JLabel("Modelo"));
        panelPrincipal.add(modelos);
        panelPrincipal.add(aceptar);
        panelPrincipal.add(new JLabel("Cantidad minima"));
        panelPrincipal.add(cantM);
        panelPrincipal.add(cancelar);
        panelPrincipal.add(new JLabel("Obsequio"));
        panelPrincipal.add(obsequio);

        //ANIADIENDO AL MARCO
        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    public void fConfigurarOptimaVendidas() {
        ModConfiguracion modifyCon=new ModConfiguracion(configuracion);
        
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Configurar cantidad optima de lamparas vendidas");
        f.setBounds(x + 30, y + 30, 500, 100);

        //CREO BOTONES
        JButton cancelar = new JButton("Cancelar");
        JButton aceptar = new JButton("Aceptar");

        
        
        
        //CREO AREAS DE TEXTO
        JTextField lamparasVendidas = new JTextField(10);
        ArrayList<JTextField> jTexto=new ArrayList<>();
        jTexto.add(lamparasVendidas);
        
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyCon.ConfigurarOptimaSell(con, jTexto);
            }
        });
        
        
        lamparasVendidas.setText(String.valueOf(configuracion.getCantOptima()));

        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 3, 20, 5));
        panelPrincipal.add(new JLabel("Cantidad óptima de lámparas vendidas"));
        panelPrincipal.add(lamparasVendidas);
        panelPrincipal.add(aceptar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(Box.createRigidArea(new Dimension(5, 0)));
        panelPrincipal.add(cancelar);

        //ANIADIENDO AL MARCO
        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    public void fConfigurarPremioSorpresa() {
        ModConfiguracion modifyCon=new ModConfiguracion(configuracion);
        
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Configurar premio sorpresa");
        f.setBounds(x + 30, y + 30, 500, 100);

        //CREO BOTONES
        JButton aceptar = new JButton("Aceptar");
        JButton cancelar = new JButton("Cancelar");

        //CREO AREAS DE TEXTO
        JTextField numeroCliente = new JTextField(10);
        JTextField premioSorpresa = new JTextField(10);
        
        ArrayList<JTextField> texto=new ArrayList<>();
        texto.add(numeroCliente);
        texto.add(premioSorpresa);
        
        
        aceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyCon.ConfigurarPremioSor(con, texto);
            }
        });
        
        
        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 3, 20, 5));
        panelPrincipal.add(new JLabel("Numero de cliente"));
        panelPrincipal.add(numeroCliente);
        panelPrincipal.add(aceptar);
        panelPrincipal.add(new JLabel("Premio Sorpresa"));
        panelPrincipal.add(premioSorpresa);
        panelPrincipal.add(cancelar);

        //ANIADO AL PANEL
        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    public void fAcercaTienda() {
        //CREO MARCO
        JFrame f = new JFrame();
        f.setTitle("Acerca de Tienda");
        f.setBounds(x + 30, y + 30, 200, 100);

        //CREO AREAS DE TEXTO
        JLabel Titulo = new JLabel("TIENTDA 1.0");
        JLabel autores = new JLabel("AUTORES");
        JLabel nombre1 = new JLabel("DILAN GOMEZ TOAZA");

        //CREO PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.PAGE_AXIS));
        panelPrincipal.add(Titulo);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(autores);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(nombre1);

        //ANIADO AL MARCO
        f.getContentPane().add(BorderLayout.CENTER, panelPrincipal);
        f.setVisible(true);
    }

    private int x = 500;
    private int y = 200;
}
