package org.example.ConexionDulceria;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

//Aqui se almacenara la info a corto plazo de las especificaciones de cada dulce.
public class TablaDulces {
    private int ID;
    private String NombreDulce;
    private String TipoDeDulce;
    private Double CantidadGramos;
    private Double PrecioDulce;
    private String URL;

    public TablaDulces() {
    }

    public TablaDulces(int ID, String nombreDulce, String tipoDeDulce, Double cantidadGramos, Double precioDulce, String URL) {
        this.ID = ID;
        NombreDulce = nombreDulce;
        TipoDeDulce = tipoDeDulce;
        CantidadGramos = cantidadGramos;
        PrecioDulce = precioDulce;
        this.URL = URL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreDulce() {
        return NombreDulce;
    }

    public void setNombreDulce(String nombreDulce) {
        NombreDulce = nombreDulce;
    }

    public String getTipoDeDulce() {
        return TipoDeDulce;
    }

    public void setTipoDeDulce(String tipoDeDulce) {
        TipoDeDulce = tipoDeDulce;
    }

    public Double getCantidadGramos() {
        return CantidadGramos;
    }

    public void setCantidadGramos(Double cantidadGramos) {
        CantidadGramos = cantidadGramos;
    }

    public Double getPrecioDulce() {
        return PrecioDulce;
    }

    public void setPrecioDulce(Double precioDulce) {
        PrecioDulce = precioDulce;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "TablaDulces{" +
                "ID=" + ID +
                ", NombreDulce='" + NombreDulce + '\'' +
                ", TipoDeDulce='" + TipoDeDulce + '\'' +
                ", CantidadGramos=" + CantidadGramos +
                ", PrecioDulce=" + PrecioDulce +
                ", URL='" + URL + '\'' +
                '}';
    }

    //investigaar por q no se que pinga hace
    public ImageIcon getImagen() throws MalformedURLException{
        URL urlImagen=new URL(this.URL);
        return new ImageIcon(urlImagen);
    }

}
