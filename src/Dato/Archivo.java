/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

import Logico.Lampara;
import Logico.Configuracion;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Dilan Gomez Toaza
 */
public class Archivo {

    //Logico.Lampara lamp = new Logico.Lampara();
    PrintWriter linea;
    FileWriter escribir;
    FileReader leer;
    File archivo;

    public ArrayList<Lampara> LeerArchivo() throws IOException {
        //https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
        ArrayList<Lampara> lamparas = new ArrayList<>();
        try {
            File folder = new File("Modelos");
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                Lampara lamp = new Lampara();
                lamp.setModelo(reader.readLine());
                lamp.setPrecio(Double.valueOf(reader.readLine()));
                lamp.setPotencia(Integer.valueOf(reader.readLine()));
                lamp.setColor(reader.readLine());
                lamp.setNluces(Integer.valueOf(reader.readLine()));
                lamparas.add(lamp);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lamparas;
    }

    public Configuracion LeerConfiguracion(){
        Configuracion config = new Configuracion();
        try {
            archivo = new File("Configuracion\\Configuracion.txt");
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            config.setPorcentaje1(Double.valueOf(reader.readLine()));
            config.setPorcentaje2(Double.valueOf(reader.readLine()));
            config.setPorcentaje3(Double.valueOf(reader.readLine()));
            config.setPorcentaje4(Double.valueOf(reader.readLine()));
            config.setCantOptima(Integer.valueOf(reader.readLine()));
            config.setModeloObsequiable(reader.readLine());
            config.setCantMinGif(Integer.valueOf(reader.readLine()));
            config.setObsequio(reader.readLine());
            config.setNumClientSor(Integer.valueOf(reader.readLine()));
            config.setPremioSor(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return config;
    }

    public void UpdateModel(String model, ArrayList<Lampara> lamparas) throws IOException {
        
        archivo = new File("Modelos\\" + model + ".txt");
        
        
        for (int i = 0; i < lamparas.size(); i++) {
            if (model.equals(lamparas.get(i).getModelo())) {
                Lampara lamp = lamparas.get(i);
                escribir = new FileWriter(archivo, false);
                
                linea = new PrintWriter(escribir);
                linea.println(lamp.getModelo());
                linea.println(lamp.getPrecio());
                linea.println(lamp.getPotencia());
                linea.println(lamp.getColor());
                linea.println(lamp.getNluces());
                 
                linea.close();
                escribir.close();
            }
        }
    }
        public void UpdateConfig(Configuracion config) throws IOException {
        
        archivo = new File("Configuracion\\Configuracion.txt");
        archivo.delete();

                escribir = new FileWriter(archivo, false);
                linea = new PrintWriter(escribir);
                linea.println(config.getPorcentaje1());
                linea.println(config.getPorcentaje2());
                linea.println(config.getPorcentaje3());
                linea.println(config.getPorcentaje4());
                linea.println(config.getCantOptima());
                linea.println(config.getModeloObsequiable());
                linea.println(config.getCantMinGif());
                linea.println(config.getObsequio());
                linea.println(config.getNumClientSor());
                linea.println(config.getPremioSor());

                linea.close();
                escribir.close();
            }
        }
    

