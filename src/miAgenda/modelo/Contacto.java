/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miAgenda.modelo;

/**
 *
 * @author Alonso
 */
//Clase contacto con sus debidos atributos 
public class Contacto {
    private int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String direccion;
    private String etiqueta;

    //Aca tenemos un metodo constructor vacio 
    public Contacto() {}

    //Aca el constructor lleno 
    public Contacto(int id, String nombres, String apellidos, String telefono, String email, String direccion, String etiqueta) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.etiqueta = etiqueta;
    }

    //Metodos getter y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEtiqueta() { return etiqueta; }
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }
    //Metodo toString 
    @Override
    public String toString() {
    return nombres + " " + apellidos;
    }
}