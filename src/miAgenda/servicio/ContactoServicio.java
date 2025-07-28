/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.servicio;

import java.util.List;
import miAgenda.dao.ContactoDAO;
import miAgenda.modelo.Contacto;
//Utiliza la clase ContactoDAO para acceder a la base de datos
/**
 *
 * @author Ben
 */
//Calse ContactoServicio 
public class ContactoServicio {

    private ContactoDAO dao;
    //Constructor que inicializa el DAO de contacto
    public ContactoServicio() {
        dao = new ContactoDAO();
    }
    //Actualiza la información de un contacto existente
    public boolean actualizarContacto(Contacto c) {
    return dao.actualizarContacto(c);
    }
    //elimina un contacto por su ID 
    public boolean eliminarContacto(int id) {
    return dao.eliminarContacto(id);
    }
    //Busca un contacto por el ID 
    public Contacto buscarPorId(int id) {
    return dao.buscarPorId(id);
    }
    //Guarda un nuevo contacto en la base de datos
    public boolean guardarContacto(Contacto c) {
        // Aquí podrías agregar validaciones en el futuro
        return dao.insertarContacto(c);
    }
    // lista de todos los contacto guardados 
    public List<Contacto> listarContactos() {
        return dao.obtenerTodos();
    }
}
