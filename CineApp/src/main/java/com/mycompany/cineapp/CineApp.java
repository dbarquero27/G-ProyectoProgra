/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cineapp;

/**
 *
 * @author DylanCO
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;

public class CineApp {
    public static void main(String[] args) {

        Usuario[] usuarios = {
            new Usuario("Admin", "Admin", "admin", "123", "admin@example.com"),
            new Usuario("Dylan", "Castro", "Dylan", "999", "dylan@example.com"),
            new Usuario("David", "Barquero", "David", "123", "david4@example.com")
        };

    
        int filas = 5;
        int columnas = 7;
        int capacidad = filas * columnas;

       
        Asiento[][] asientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento(i, j);
            }
        }

        Reportes reportes = new Reportes();

        Usuario usuarioActual = null;

        while (usuarioActual == null) {
            String usuarioIngresado = JOptionPane.showInputDialog("Ingrese su usuario:");
            String passwordIngresado = JOptionPane.showInputDialog("Ingrese su contraseña:");

            for (Usuario usuario : usuarios) {
                if (usuario.usuario.equals(usuarioIngresado) && usuario.password.equals(passwordIngresado)) {
                    usuarioActual = usuario;
                    break;
                }
            }

            if (usuarioActual == null) {
                int opcion = JOptionPane.showConfirmDialog(null, "Usuario o contraseña incorrectos. ¿Desea intentar nuevamente?", "Cine App", JOptionPane.YES_NO_OPTION);
                if (opcion != JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Saliendo...", "Cine App", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Bienvenido, " + usuarioActual.nombre + " " + usuarioActual.apellidos + "!", "Cine App", JOptionPane.INFORMATION_MESSAGE);


        while (capacidad > 0) {
            
            String[] eventos = {
                "Oppenheimer (Mayores de 18 años)",
                "Barbie",
                "Transformers"
            };
            int eventoSeleccionado = JOptionPane.showOptionDialog(null, "Seleccione un evento:", "Cine App", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, eventos, eventos[0]);

            if (eventoSeleccionado == 0) {
                int edadCliente = Integer.parseInt(JOptionPane.showInputDialog("Por favor, ingrese su edad:"));
                if (edadCliente < 18) {
                    JOptionPane.showMessageDialog(null, "Lo siento, este evento es solo para mayores de 18 años.", "Cine App", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
            }

            StringBuilder salaTexto = new StringBuilder("Estado actual de la sala:\n\n");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    salaTexto.append(asientos[i][j].reservado ? "X " : "O ");
                }
                salaTexto.append("\n");
            }

            JOptionPane.showMessageDialog(null, salaTexto.toString(), "Cine App", JOptionPane.INFORMATION_MESSAGE);

            int filaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la fila (0-4): "));
            int columnaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la columna (0-6): "));

            if (filaSeleccionada >= 0 && filaSeleccionada < filas && columnaSeleccionada >= 0 && columnaSeleccionada < columnas) {
                Asiento asientoSeleccionado = asientos[filaSeleccionada][columnaSeleccionada];
                if (!asientoSeleccionado.reservado) {
                    asientoSeleccionado.reservado = true;
                    capacidad--;

                    String descripcionEvento = eventos[eventoSeleccionado];
            String mesAsignado = "Agosto";  
            int numeroAsiento = (filaSeleccionada * columnas) + columnaSeleccionada + 1;  
            double costoAsiento = 3500;  
            Factura factura = new Factura(descripcionEvento, mesAsignado, usuarioActual.nombre + " " + usuarioActual.apellidos, numeroAsiento, costoAsiento);
            reportes.agregarFactura(factura);

            JOptionPane.showMessageDialog(null, "¡Asiento reservado con éxito!\nNúmero de factura: " + reportes.facturas.size(), "Cine App", JOptionPane.INFORMATION_MESSAGE);
        } else {
                    JOptionPane.showMessageDialog(null, "El asiento seleccionado ya está ocupado.", "Cine App", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selección de asiento inválida.", "Cine App", JOptionPane.ERROR_MESSAGE);
            }

            if (capacidad > 0) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea reservar otro asiento?", "Cine App", JOptionPane.YES_NO_OPTION);
                if (opcion != JOptionPane.YES_OPTION) {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡La sala está llena! No hay más asientos disponibles.", "Cine App", JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }

        reportes.generarReporte();

        JOptionPane.showMessageDialog(null, "Gracias por usar la aplicación de Cine.", "Cine App", JOptionPane.INFORMATION_MESSAGE);
    }
}
