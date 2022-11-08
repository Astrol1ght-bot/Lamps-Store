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
public class Venta {

    int ClienteNum = 0;
    Mantenimiento mant = new Mantenimiento();

    public void Vender(String model, ArrayList<JTextField> j, JTextArea texto, Configuracion config, ArrayList<Lampara> lamparas, double precio, Archivo lamp) {
        try {
            lamp.LeerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        mant.StartMapping(lamp);
        ClienteNum++;
        precio=0;
        double precioFinal = 0;
        boolean gif = false;
        boolean next = false;
        for (int i = 0; i < lamparas.size(); i++) {
            if (model.equals(lamparas.get(i).getModelo())) {
                precio = lamparas.get(i).getPrecio();
                if ("KASK".equals(model)) {
                    gif = true;
                }
                next = true;
            }
            if (next) {
                int cant = Integer.parseInt(j.get(1).getText());
                if (cant > 0 && cant < 6) {
                    precioFinal = (precio * cant) - ((precio * cant) / config.getPorcentaje1());
                } else if (cant > 5 && cant < 11) {
                    precioFinal = (precio * cant) - ((precio * cant) / config.getPorcentaje2());
                } else if (cant > 10 && cant < 16) {
                    precioFinal = (precio * cant) - ((precio * cant) / config.getPorcentaje3());
                } else if (cant > 15) {
                    precioFinal = (precio * cant) - ((precio * cant) / config.getPorcentaje4());
                }
                String newTexto = "BOLETA\n" + "Modelo: " + model + "\nPrecio: " + precio
                        + "\nUnidades adquiridas: " + cant + "\nPagar: " + precioFinal;
                if (gif && cant >= config.getCantMinGif()) {
                    newTexto += "\nObsequio:" + config.getObsequio();
                } else if (ClienteNum == config.getNumClientSor()) {
                    newTexto += "\nPremio: " + config.getPremioSor();
                }
                texto.setText(newTexto);
                lamparas.get(i).setTotalAcumul(lamparas.get(i).getTotalAcumul() + (precio * cant));
                UpdateForReport(model, cant, precioFinal, lamparas);
            }
        }
    }

    private void UpdateForReport(String model, int cant, double precioFinal, ArrayList<Lampara> lamparas) {
        for (int i = 0; i < lamparas.size(); i++) {
            if (model.equals(lamparas.get(i).getModelo())) {
                lamparas.get(i).setTotalCantidadVentas(lamparas.get(i).getTotalCantidadVentas() + 1);
                lamparas.get(i).setTotalCantidadUnitVendidas(lamparas.get(i).getTotalCantidadUnitVendidas() + cant);
                lamparas.get(i).setTotalAcumul(lamparas.get(i).getTotalAcumul() + precioFinal);
            }
        }
    }

    public void VentaXLampara(ArrayList<Lampara> lamparas, JTextArea texto, Archivo lamp) {
        try {
            lamp.LeerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        double ingeac = 0;
        String newTexto = "";
        for (int i = 0; i < lamparas.size(); i++) {
            
            if(i>0){newTexto+="\n";}
            newTexto += "Modelo=" + lamparas.get(i).getModelo() + "\nCantidad total de ventas=" + lamparas.get(i).getTotalCantidadVentas()
                    + "\nCantidad total de unidades vendidads=" + lamparas.get(i).getTotalCantidadUnitVendidas() + "\nImporte total acumulado=" + lamparas.get(i).getTotalAcumul();
            ingeac += lamparas.get(i).getTotalAcumul();
        }
        newTexto += "Importe total acumulado total=" + String.valueOf(ingeac);
        texto.setText(newTexto);
    }

    public void MaletaVentaOptima(ArrayList<Lampara> lamparas, JTextArea JTexto, Archivo con, Archivo lamp) {
        try {
            lamparas =lamp.LeerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Configuracion config=con.LeerConfiguracion();

        String newTexto = "";
        for (int i = 0; i < lamparas.size(); i++) {
            if (lamparas.get(i).getTotalCantidadUnitVendidas() >= config.getCantOptima()) {
                newTexto += "Modelo=" + lamparas.get(i).getModelo() + "\nCantidad total de unidades vendidas="
                        + lamparas.get(i).getTotalCantidadUnitVendidas();              
            }if(lamparas.get(i).getTotalCantidadUnitVendidas()==0){newTexto="NO HAY";}
        }
        JTexto.setText(newTexto);
    }

    public void PrecioPromedio(ArrayList<Lampara> lamparas, JTextArea JTexto) {
        String newTexto = "";
        for (int i = 0; i < lamparas.size()-1; i++) {
            if (lamparas.get(i).getPrecio() > promPrecio(lamparas)) {
                if(i>0){newTexto+="\n";}
                newTexto += "Modelo=" + lamparas.get(i).getModelo() + "\nPrecio=" + lamparas.get(i).getPrecio() + "(mayor al promedio)";
            } else {
                if(i>0){newTexto+="\n";}
                newTexto += "Modelo=" + lamparas.get(i).getModelo() + "\nPrecio=" + lamparas.get(i).getPrecio() + "(menor al promedio)";
            }
        }
        JTexto.setText(newTexto);
    }

    public void PromedioMaxMin(ArrayList<Lampara> lamparas, JTextArea JTexto) {
        double max = 0, min = 0;
        double pmax = 0, pmin = 0;
        String newTexto = "";
        for (int i = 0; i < lamparas.size(); i++) {
            if (lamparas.get(i).getPrecio() > max) {
                max = lamparas.get(i).getPrecio();
            }
            if (lamparas.get(i).getPrecio() < min) {
                min = lamparas.get(i).getPrecio();
            }
            if (lamparas.get(i).getPotencia() > pmax) {
                pmax = lamparas.get(i).getPotencia();
            }
            if (lamparas.get(i).getPotencia() < pmin) {
                pmin = lamparas.get(i).getPotencia();
            }
        }
        newTexto += "Precio Promedio=" + promPrecio(lamparas) + "\nPrecio minimo=" + min + "\nPrecio maximo=" + max + "\n\nPotencia promedio="
                + promPotencia(lamparas) + "\nPotencia minimo=" + pmin + "\nPorencia maxima=" + pmax;
        JTexto.setText(newTexto);
    }

    private double promPrecio(ArrayList<Lampara> lamparas) {
        double promedio = 0;
        for (int i = 0; i < lamparas.size(); i++) {
            promedio += lamparas.get(i).getPrecio();
        }
        return promedio / lamparas.size();
    }

    private double promPotencia(ArrayList<Lampara> lamparas) {
        double promedio = 0;
        for (int i = 0; i < lamparas.size(); i++) {
            promedio += lamparas.get(i).getPotencia();
        }
        return promedio / lamparas.size();
    }
}
