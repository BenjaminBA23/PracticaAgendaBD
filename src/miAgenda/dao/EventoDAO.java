/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import miAgenda.modelo.Evento;

/**
 *
 * @author Ben
 */
public class EventoDAO {
    // metodo para insertar un nuevo evento en la base de datos
    public boolean insertarEvento(Evento evento) {
        // consulta sql para insertar un evento
        String sql = "INSERT INTO eventos (fecha, hora, descripcion, ubicacion, contacto_id) VALUES (?, ?, ?, ?, ?)";
        // se usa try con recursos para manejar la conexion y el preparedstatement
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // se asignan los valores del objeto evento a los signos de pregunta de la consulta
            stmt.setDate(1, Date.valueOf(evento.getFecha()));
            stmt.setTime(2, Time.valueOf(evento.getHora()));
            stmt.setString(3, evento.getDescripcion());
            stmt.setString(4, evento.getUbicacion());
            stmt.setInt(5, evento.getContactoId());
            // se ejecuta la consulta de insercion
            stmt.executeUpdate();
            return true; // se retorna true si todo sale bien
        } catch (SQLException e) {
            e.printStackTrace(); // se imprime el error si algo falla
            return false; // se retorna false si hay un error
        }
    }
    // metodo para obtener la lista de todos los eventos en la base de datos
    public List<Evento> listarEventos() {
        // se crea una lista vacia para guardar los eventos
        List<Evento> lista = new ArrayList<>();
        // consulta sql para seleccionar todos los eventos
        String sql = "SELECT * FROM eventos";
        // se usa try con recursos para manejar conexion, consulta y resultado
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            // se recorre el resultado fila por fila
            while (rs.next()) {
                // se crea un nuevo objeto evento y se llenan sus campos
                Evento e = new Evento();
                e.setId(rs.getInt("id"));
                e.setFecha(rs.getDate("fecha").toLocalDate());
                e.setHora(rs.getTime("hora").toLocalTime());
                e.setDescripcion(rs.getString("descripcion"));
                e.setUbicacion(rs.getString("ubicacion"));
                e.setContactoId(rs.getInt("contacto_id"));
                // se agrega el evento a la lista
                lista.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // se imprime el error si ocurre
        }
        // se retorna la lista con los eventos
        return lista;
    }
}
