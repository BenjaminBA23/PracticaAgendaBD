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

    public boolean insertarEvento(Evento evento) {
        String sql = "INSERT INTO eventos (fecha, hora, descripcion, ubicacion, contacto_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(evento.getFecha()));
            stmt.setTime(2, Time.valueOf(evento.getHora()));
            stmt.setString(3, evento.getDescripcion());
            stmt.setString(4, evento.getUbicacion());
            stmt.setInt(5, evento.getContactoId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Evento> listarEventos() {
        List<Evento> lista = new ArrayList<>();
        String sql = "SELECT * FROM eventos";

        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evento e = new Evento();
                e.setId(rs.getInt("id"));
                e.setFecha(rs.getDate("fecha").toLocalDate());
                e.setHora(rs.getTime("hora").toLocalTime());
                e.setDescripcion(rs.getString("descripcion"));
                e.setUbicacion(rs.getString("ubicacion"));
                e.setContactoId(rs.getInt("contacto_id"));

                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
