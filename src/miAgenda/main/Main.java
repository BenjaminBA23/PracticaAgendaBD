/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.main;

import miAgenda.ui.VentanaPrincipal;

/**
 *
 * @author Ben
 */
public class Main {
    public static void main(String[] args) {
        // Aquí configuramos la apariencia de la interfaz (opcional)
        try {
            // Establecer la apariencia 'Nimbus' para una interfaz moderna
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Crear y mostrar la ventana principal
        VentanaPrincipal ventana = new VentanaPrincipal();  // Asegúrate de tener esta clase
        ventana.setLocationRelativeTo(null); // Centra la ventana
        ventana.setVisible(true); // Muestra la ventana
    }
}
