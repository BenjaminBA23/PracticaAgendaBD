/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import miAgenda.modelo.Contacto;

/**
 *
 * @author Ben
 */
public class ContactoDAO {

    public boolean insertarContacto(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombres, apellidos, telefono, email, direccion, etiqueta) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contacto.getNombres());
            stmt.setString(2, contacto.getApellidos());
            stmt.setString(3, contacto.getTelefono());
            stmt.setString(4, contacto.getEmail());
            stmt.setString(5, contacto.getDireccion());
            stmt.setString(6, contacto.getEtiqueta());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Contacto> obtenerTodos() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";

        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                c.setEtiqueta(rs.getString("etiqueta"));

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public boolean eliminarContacto(int id) {
    String sql = "DELETE FROM contactos WHERE id = ?";
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public boolean actualizarContacto(Contacto c) {
        String sql = "UPDATE contactos SET nombres=?, apellidos=?, telefono=?, email=?, direccion=?, etiqueta=? WHERE id=?";
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombres());
            stmt.setString(2, c.getApellidos());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getDireccion());
            stmt.setString(6, c.getEtiqueta());
            stmt.setInt(7, c.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        
    public Contacto buscarPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                c.setEtiqueta(rs.getString("etiqueta"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
