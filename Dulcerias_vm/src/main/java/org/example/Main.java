package org.example;


import org.example.Control.Controlador;
import org.example.Vista.Vista;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Vista view=new Vista("MVC Y JDBC");
        Controlador controller=new Controlador(view);


    }
}