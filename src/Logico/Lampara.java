/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logico;

/**
 *
 * @author Dilan Gomez Toaza
 */
public class Lampara {

    private String _modelo;
    private double _precio;
    private int _potencia;
    private String _color;
    private int _nluces;
    private int _totalCantidadVentas;
    private int _totalCantidadUnitVendidas;
    private double _totalAcumul;

    @Override
    public String toString() {
        return "modelo=" + _modelo + ", \nprecio=" + _precio + ", \npotencia=" + _potencia + ", \ncolor=" + _color + ", \nluces=" + _nluces;
    }

    public int getTotalCantidadVentas() {
        return _totalCantidadVentas;
    }

    public void setTotalCantidadVentas(int _totalCantidadVentas) {
        this._totalCantidadVentas = _totalCantidadVentas;
    }

    public int getTotalCantidadUnitVendidas() {
        return _totalCantidadUnitVendidas;
    }

    public void setTotalCantidadUnitVendidas(int _totalCantidadUnitVendidas) {
        this._totalCantidadUnitVendidas = _totalCantidadUnitVendidas;
    }

    public double getTotalAcumul() {
        return _totalAcumul;
    }

    public void setTotalAcumul(double _totalAcumul) {
        this._totalAcumul = _totalAcumul;
    }

    public String getModelo() {
        return _modelo;
    }

    public void setModelo(String _modelo) {
        this._modelo = _modelo;
    }

    public double getPrecio() {
        return _precio;
    }

    public void setPrecio(double _precio) {
        this._precio = _precio;
    }

    public int getPotencia() {
        return _potencia;
    }

    public void setPotencia(int _potencia) {
        this._potencia = _potencia;
    }

    public String getColor() {
        return _color;
    }

    public void setColor(String _color) {
        this._color = _color;
    }

    public int getNluces() {
        return _nluces;
    }

    public void setNluces(int _nluces) {
        this._nluces = _nluces;
    }

}
