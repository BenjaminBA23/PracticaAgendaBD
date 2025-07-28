/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.servicio;

import java.util.List;
import miAgenda.dao.ContactoDAO;
import miAgenda.modelo.Contacto;

/**
 *
 * @author Ben
 */
public class ContactoServicio {

    private ContactoDAO dao;

    public ContactoServicio() {
        dao = new ContactoDAO();
    }
    public boolean actualizarContacto(Contacto c) {
    return dao.actualizarContacto(c);
    }
    public boolean eliminarContacto(int id) {
    return dao.eliminarContacto(id);
    }
    
    public Contacto buscarPorId(int id) {
    return dao.buscarPorId(id);
    }

    public boolean guardarContacto(Contacto c) {
        // Aquí podrías agregar validaciones en el futuro
        return dao.insertarContacto(c);
    }

    public List<Contacto> listarContactos() {
        return dao.obtenerTodos();
    }
}
