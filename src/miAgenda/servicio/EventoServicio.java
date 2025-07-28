/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.servicio;
//importaciones 
import java.util.List;
import miAgenda.dao.EventoDAO;
import miAgenda.modelo.Evento;

/**
 *
 * @author Ben
 */
//clase 
public class EventoServicio {

    private EventoDAO dao;
    //Constructor que inicializa el DAO de eventos
    public EventoServicio() {
        dao = new EventoDAO();
    }
    //Guarda un nuevo evento en la base de datos 
    public boolean guardarEvento(Evento evento) {
        // Aquí puedes agregar validaciones si deseas
        return dao.insertarEvento(evento);
    }
    //Obtiene la lista de todos los eventos registrados
    public List<Evento> listarEventos() {
        return dao.listarEventos();
    }
    
    
}

