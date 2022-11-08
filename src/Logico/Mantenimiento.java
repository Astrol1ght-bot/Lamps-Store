/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

import Dato.Archivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dilan Gomez Toaza
 */
public class Mantenimiento {


    ArrayList<Lampara> lamparas;

    public void StartMapping(Archivo ar) {
        ar = new Archivo();
        try {
            lamparas = ar.LeerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Lampara> getArrayList() {
        return lamparas;
    }

    public void ConsultarLampara(String model, ArrayList<JTextField> JTexto) {
        for (int i = 0; i < lamparas.size(); i++) {
            if (model.equals(lamparas.get(i).getModelo())) {
                JTexto.get(0).setText(String.valueOf(lamparas.get(i).getPrecio()));
                JTexto.get(1).setText(String.valueOf(lamparas.get(i).getPotencia()));
                JTexto.get(2).setText(lamparas.get(i).getColor());
                JTexto.get(3).setText(String.valueOf(lamparas.get(i).getNluces()));
            }
        }
    }

    public void ModificarLampara(String model, Archivo ar, ArrayList<JTextField> JTexto) {
        for (int i = 0; i < lamparas.size(); i++) {
            if (model.equals(lamparas.get(i).getModelo())) {
                Lampara lamp = lamparas.get(i);
                ar = new Archivo();

                double precio = Double.parseDouble(JTexto.get(0).getText());
                lamp.setPrecio(precio);

                int potencia = Integer.parseInt(JTexto.get(1).getText());
                lamp.setPotencia(potencia);

                String color = JTexto.get(2).getText();
                lamp.setColor(color);

                int luces = Integer.parseInt(JTexto.get(3).getText());
                lamp.setNluces(luces);
            }
        }
        try {
            ar.UpdateModel(model, lamparas);
        } catch (IOException ex) {
            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ListarLamparas(JTextArea texto) {
        String todo="";
        
        for (int i = 0; i < lamparas.size();i++) {
            Lampara lamp = lamparas.get(i);
             todo +=  "Modelo:    " + lamp.getModelo() + "\n"
                    + "Precio:    " + String.valueOf(lamp.getPrecio()) + "\n"
                    + "Potencia:  " + String.valueOf(lamp.getPotencia()) + "\n"
                    + "Color:     " + lamp.getColor() + "\n"
                    + "Luces:     " + String.valueOf(lamp.getNluces()) + "\n\n";

            
        }
        texto.setText("LISTADO DE MALETAS\n\n" + todo);
    }
}
