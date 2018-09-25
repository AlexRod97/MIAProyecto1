/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.util.List;

/**
 *
 * @author Bryan Mejía
 */
public class Secuencial {
    
    //TODO: todos los archivos con descriptor
    //TODO: Validaciones tipo de dato
    //TODO: separador '|'
    
    final static String separador = "|";
    final static String nuevaLinea = "\r\n";
    
    /**
     * Invocar al crear un archivo nuevo para crear un descriptor
     * @param nombre
     * @return 
     */
    private static File CrearDescriptor(String nombre){
        
        File file;
        String data = "";
       
        data = "C:\\MEIA\\desc_" + nombre.toString() + ".txt";
       
        file = new File(data);
        
        return file;
    }
    
    
    /**
     *  Crea el archivo mediante el nombre ingresado
     * si el archivo existe, tirara un FileException
     * @param nombre
     * @return
     * @throws IOException 
     */
    public static File CrearArchivo(String nombre) throws IOException{
        
        File file;
        file = new File("C:\\MEIA\\" + nombre + ".txt");
        
        boolean exist = file.createNewFile();
        
        if (exist) {
            throw new IOException("el archivo ya existe");
        }
        
        //crea un archivo APILO con la metadata en default
        FileWriter fw = new FileWriter(file);
        fw.write("nombre_simbolico: ");
        fw.write("fecha_creacion: ");
        fw.write("usuario_creacion: ");
        fw.write("fecha_modificacion: ");
        fw.write("usuario_modificacion: ");
        fw.write("#_registro: ");
        fw.write("registros_activos: ");
        fw.write("registros_inactivos: ");
        fw.write("max_reorganizacion: ");
        return file;
    }
    
    /**
     * Se modifica la entrada de un usuario u archivo
     * @param dato
     * @param Archivo
     * @return
     * @throws IOException 
     */
    private static boolean ModificarEntrada(String dato,File Archivo) throws 
            IOException{
        
        return false;
    }
    
    /**
     * se manda un listado a escribir en el archivo, 
     * todo separado mediante split.
     * @param datos
     * @param Archivo
     * @return
     * @throws IOException
     * @throws NullPointerException 
     */
    private static boolean EscribirLista(String datos,File Archivo) throws IOException,
            NullPointerException{
        
        try{
        FileWriter fw = new FileWriter(Archivo);        
        fw.write(datos);
        //se agrega un salto de linea nuevo
        fw.write(nuevaLinea,datos.length(),nuevaLinea.length());
        
        return true;
        
        }catch(IOException e){
            return false;
        }
       
    }
    
}
