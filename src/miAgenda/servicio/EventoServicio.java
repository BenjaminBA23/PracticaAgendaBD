/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.servicio;

import java.util.List;
import miAgenda.dao.EventoDAO;
import miAgenda.modelo.Evento;

/**
 *
 * @author Ben
 */
public class EventoServicio {

    private EventoDAO dao;

    public EventoServicio() {
        dao = new EventoDAO();
    }

    public boolean guardarEvento(Evento evento) {
        // Aquí puedes agregar validaciones si deseas
        return dao.insertarEvento(evento);
    }

    public List<Evento> listarEventos() {
        return dao.listarEventos();
    }
    
    
}

