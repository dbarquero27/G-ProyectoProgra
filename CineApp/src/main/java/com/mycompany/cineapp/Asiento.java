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

class Asiento {
    int fila;
    int columna;
    boolean reservado;

    Asiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.reservado = false;
    }
}
