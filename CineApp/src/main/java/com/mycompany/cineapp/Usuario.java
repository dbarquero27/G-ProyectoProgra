/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cineapp;

/**
 *
 * @author DylanCO
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;

class Usuario {
    String nombre;
    String apellidos;
    String usuario;
    String password;
    String correo;

    Usuario(String nombre, String apellidos, String usuario, String password, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
    }
}
