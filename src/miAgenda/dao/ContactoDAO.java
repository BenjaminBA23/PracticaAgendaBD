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
// metodo para insertar un nuevo contacto en la base de datos
    public boolean insertarContacto(Contacto contacto) {// consulta sql para insertar un contacto
        String sql = "INSERT INTO contactos (nombres, apellidos, telefono, email, direccion, etiqueta) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
// usamos try-with-resources para cerrar automaticamente la conexion
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
// asignamos los valores a los parametros de la consulta
            stmt.setString(1, contacto.getNombres());
            stmt.setString(2, contacto.getApellidos());
            stmt.setString(3, contacto.getTelefono());
            stmt.setString(4, contacto.getEmail());
            stmt.setString(5, contacto.getDireccion());
            stmt.setString(6, contacto.getEtiqueta());
// ejecutamos la consulta
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Contacto> obtenerTodos() {  // metodo para obtener todos los contactos de la base de datos
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contactos";

        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
 // recorremos el resultado de la consulta
            while (rs.next()) {
                Contacto c = new Contacto();// creamos un nuevo objeto contacto
                c.setId(rs.getInt("id"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setTelefono(rs.getString("telefono"));
                c.setEmail(rs.getString("email"));
                c.setDireccion(rs.getString("direccion"));
                c.setEtiqueta(rs.getString("etiqueta"));

                lista.add(c); // agregamos el contacto a la lista
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public boolean eliminarContacto(int id) {  // metodo para eliminar un contacto por su id
    String sql = "DELETE FROM contactos WHERE id = ?";
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // asignamos el id al parametro de la consulta
        return stmt.executeUpdate() > 0;  // si se elimina al menos una fila, retornamos true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public boolean actualizarContacto(Contacto c) {// metodo para actualizar un contacto existente
        String sql = "UPDATE contactos SET nombres=?, apellidos=?, telefono=?, email=?, direccion=?, etiqueta=? WHERE id=?";
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombres());// asignamos los valores actualizados
            stmt.setString(2, c.getApellidos());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getDireccion());
            stmt.setString(6, c.getEtiqueta());
            stmt.setInt(7, c.getId());

            return stmt.executeUpdate() > 0;// si se actualiza al menos una fila, retornamos true

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
         // metodo para buscar un contacto por su id
    public Contacto buscarPorId(int id) {
        String sql = "SELECT * FROM contactos WHERE id = ?";
        try (Connection conn = ConectorBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 // asignamos el id al parametro
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {// si encontramos un resultado, lo convertimos en un objeto contacto
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
        return null;  // si no se encontro ningun contacto, retornamos null
    }
}
