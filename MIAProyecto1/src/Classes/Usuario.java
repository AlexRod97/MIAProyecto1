/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rodri
 */
public class Usuario implements IArchivo{
    
    private String Usuario; 
    private String Nombre;
    private String Apellido; 
    private String Password; 
    private int Rol; 
    private Date Fecha_Nacimiento; 
    private String Correo_Alterno; 
    private int Telefono; 
    private String Path_Fotografia; 
    private int Estatus; 

    public Usuario(String Usuario, String Nombre, String Apellido, String Password, int Rol, Date Fecha_Nacimiento, String Correo_Alterno, int Telefono, String Path_Fotografia, int Estatus) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Password = Password;
        this.Rol = Rol;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Correo_Alterno = Correo_Alterno;
        this.Telefono = Telefono;
        this.Path_Fotografia = Path_Fotografia;
        this.Estatus = Estatus;
    }
   
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    public Date getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getCorreo_Alterno() {
        return Correo_Alterno;
    }

    public void setCorreo_Alterno(String Correo_Alterno) {
        this.Correo_Alterno = Correo_Alterno;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getPath_Fotografia() {
        return Path_Fotografia;
    }

    public void setPath_Fotografia(String Path_Fotografia) {
        this.Path_Fotografia = Path_Fotografia;
    }

    public int getEstatus() {
        return Estatus;
    }

    public void setEstatus(int Estatus) {
        this.Estatus = Estatus;
    }

    @Override
    public boolean EscribirDatos(String datos, File Archivo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> ObtenerDatos() throws ArrayIndexOutOfBoundsException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean CrearArchivo() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean CerrarArchivo() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
