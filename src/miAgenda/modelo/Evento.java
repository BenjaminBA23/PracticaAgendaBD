/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Ben
 */
public class Evento {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;
    private String ubicacion;
    private int contactoId;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getContactoId() { return contactoId; }
    public void setContactoId(int contactoId) { this.contactoId = contactoId; }
}
