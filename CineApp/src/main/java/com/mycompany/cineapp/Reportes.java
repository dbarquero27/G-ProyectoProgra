/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cineapp;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author DylanCO
 */
class Reportes {
    ArrayList<Factura> facturas = new ArrayList<>();

    void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    void generarReporte() {

        String eventoMasVendido = "";
        int maxVentas = 0;
        HashMap<String, Integer> ventasPorEvento = new HashMap<>();

        for (Factura factura : facturas) {
            ventasPorEvento.put(factura.descripcionEvento, ventasPorEvento.getOrDefault(factura.descripcionEvento, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : ventasPorEvento.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                eventoMasVendido = entry.getKey();
            }
        }

        String funcionMayorGanancia = "";
        double maxGanancia = 0.0;
        HashMap<String, Double> gananciasPorFuncion = new HashMap<>();

        for (Factura factura : facturas) {
            gananciasPorFuncion.put(factura.descripcionEvento, gananciasPorFuncion.getOrDefault(factura.descripcionEvento, 0.0) + factura.costoAsiento);
        }

        for (Map.Entry<String, Double> entry : gananciasPorFuncion.entrySet()) {
            if (entry.getValue() > maxGanancia) {
                maxGanancia = entry.getValue();
                funcionMayorGanancia = entry.getKey();
            }
        }

        StringBuilder facturaCompleta = new StringBuilder();
        facturaCompleta.append("Detalles de Facturas:\n\n");

        for (int i = 0; i < facturas.size(); i++) {
            facturaCompleta.append("Factura ").append(i + 1).append(":\n");
            facturaCompleta.append(facturas.get(i).toString()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, facturaCompleta.toString(), "Detalles de Facturas", JOptionPane.INFORMATION_MESSAGE);
    }
}