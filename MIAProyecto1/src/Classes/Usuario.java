/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

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
    public Puntuaciones puntuacion; 
    
    public Usuario() {    
    }

    public Usuario(String Usuario, String Nombre, String Apellido, String Password, int Rol, Date Fecha_Nacimiento, String Correo_Alterno, int Telefono, String Path_Fotografia, int Estatus) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Password = Encriptar(Password);
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
    
    public int checkPassword(String password) {
        
        puntuacion = new Puntuaciones(password); 
        return puntuacion.Verificar();
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
    
    public static String Encriptar(String cadena) {
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(cadena.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

             while (hashtext.length() < 32) {
     
                 hashtext = "0" + hashtext;
             }
 
            return hashtext;            
        }
        catch (NoSuchAlgorithmException e) {
     
           throw new RuntimeException(e);
        }         
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
    
    
   public static class Puntuaciones {
    
   String password; 
   int puntuacionFinal = 0, length  = 0, lowerCase = 0, upperCase = 0, digit = 0, symbol = 0;  
   
   private Puntuaciones (String pwd) {
       password = pwd; 
       length = password.length();
       CountCharacters(); 
   }
   
   private void CountCharacters() {
     
       for (int i = 0; i < length; i++) {
         char caracter = password.charAt(i); 
         
         if(Character.isDigit(caracter)) {
            digit++;  
         }
         else if (Character.isUpperCase(caracter)) {
           upperCase++;   
         }
         else if (Character.isLowerCase(caracter)) {
           lowerCase++;  
         }
         else {
             symbol++;
         }
                 
       }
   }   
 
   
   public int Verificar() {
    
       puntuacionFinal = 3* length; 
       
       puntuacionFinal = puntuacionFinal + (2 * upperCase); 
       
       puntuacionFinal = puntuacionFinal + ( (upperCase + lowerCase) + 1 );
       
       puntuacionFinal = puntuacionFinal + (digit + 2); 
       
       puntuacionFinal = puntuacionFinal + (symbol) * (length + 4);   
       
        if(digit <= 0) {
            
         puntuacionFinal = puntuacionFinal - 6; 
        }
        
        if( upperCase + lowerCase <= 0) {
           
            puntuacionFinal = puntuacionFinal - 3; 
        }
               
       return puntuacionFinal; 
   }
   
  
    
   }
        
}
