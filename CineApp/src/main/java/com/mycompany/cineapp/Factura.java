/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cineapp;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author DylanCO
 */
class Factura {
    Date fechaHora;
    String descripcionEvento;
    String mesAsignado;
    String nombreCliente;
    int numeroAsiento;
    double costoAsiento;

    Factura(String descripcionEvento, String mesAsignado, String nombreCliente, int numeroAsiento, double costoAsiento) {
        this.fechaHora = new Date();
        this.descripcionEvento = descripcionEvento;
        this.mesAsignado = mesAsignado;
        this.nombreCliente = nombreCliente;
        this.numeroAsiento = numeroAsiento;
        this.costoAsiento = costoAsiento;
    }
    
public String toString() {
        return "Factura\n" +
                "Fecha y Hora: " + fechaHora + '\n' +
                "Evento: " + descripcionEvento + '\n' +
                "Mes Asignado: " + mesAsignado + '\n' +
                "Nombre Cliente: " + nombreCliente + '\n' +
                "Número de Asiento: " + numeroAsiento + '\n' +
                "Costo del Asiento: $" + costoAsiento;
    }
}
