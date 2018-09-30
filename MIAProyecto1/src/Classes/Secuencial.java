/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
     * cuando se quiere crear un archivo nuevo, se llama al constructor
     * para crear los 3 archivos basicos
     * @param nombre
     * @throws IOException 
     */
    public Secuencial(String nombre, String usuarioMaster,
            String reorg) throws IOException{
     
        CrearMaster(nombre);
        CrearArchivoDesc(nombre, usuarioMaster, reorg);
        CrearBitacoraArchivo(nombre);    
        
    }
    
    /**
     * Invocar al crear un archivo nuevo para crear un descriptor
     * @param nombre
     * @return 
     */
    private static boolean CrearMaster(String nombre) throws IOException{
        
        File file = null;
        String data = "";
       
        data = "C:\\MEIA\\" + nombre.toString() + ".txt";
        
        file = new File(data);
        
        boolean flag = file.createNewFile();
        
        return flag;
    }
    
    private static boolean CrearArchivoDesc(String nombreMaster,
            String usuarioMaster, String maxReorg)throws IOException{
        
        File file = null;
        String data = "";
        
        data = "C:\\MEIA\\desc_" + nombreMaster.toString() + ".txt";
        
        file = new File(data);
        
        boolean flag = file.createNewFile();
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.append("nombre_simbolico: " + nombreMaster);
        bw.append("\r\n");
        //formateamos la fecha:
        Date date = Calendar.getInstance().getTime();
        
        DateFormat formatter = new SimpleDateFormat(
                "EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
        String today = formatter.format(date);
        
        bw.append("fecha_creacion: " + today);
        bw.append("\r\n");
        bw.append("usuario_creacion: " + usuarioMaster);
        bw.append("\r\n");
        bw.append("fecha_modificacion: " );
        bw.append("\r\n");
        bw.append("usuario_modificacion: ");
        bw.append("\r\n");
        bw.append("#_registros: " + "0");
        bw.append("\r\n");
        bw.append("registros_activos: " + "0");
        bw.append("\r\n");
        bw.append("registros_inactivos: " + "0");
        bw.append("\r\n");
        
        //deja en default si la reorganizacion maxima es 0
        if (maxReorg.equals("0")) {
            maxReorg = "5";
        }
        bw.append("max_reorganizacion: " + maxReorg);
        bw.flush();
        bw.close();
        return flag;
    }
    
    /**
     * se llama cuando se añade un dato a la bitacora
     * @param adminUser
     * @param nombreArchivoMaster
     * @return
     * @throws IOException 
     */
    private static boolean EscribirArchivoDesc(String adminUser, String
            nombreArchivoMaster)throws IOException{
        
        File file = new File("C:\\MEIA\\desc_" + nombreArchivoMaster + ".txt");
        
        
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        List<String> datos = br.lines().collect(Collectors.toList());
        List<String> info = new ArrayList<>();
        
        for (int i = 0; i < datos.size(); i++){
            String[] temp = datos.get(i).trim().split(":");
            info.add(temp[1]);
        }
        
        br.close();
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        int numReg = Integer.parseInt(info.get(5));
        numReg = numReg++;
        
        int activeReg = Integer.parseInt(info.get(6));
        activeReg = activeReg++;
        
        int inactReg = Integer.parseInt(info.get(7));
        inactReg = numReg - activeReg; 
        
        
        bw.append("nombre_simbolico: " + nombreArchivoMaster);
        bw.append("\r\n");
       
        //formateamos la fecha:
        Date date = Calendar.getInstance().getTime();
        
        DateFormat formatter = new SimpleDateFormat(
                "EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
        String today = formatter.format(date);
        
        bw.append("fecha_creacion: " + info.get(1));
        bw.append("\r\n");
        bw.append("usuario_creacion: " + info.get(2));
        bw.append("\r\n");
        bw.append("fecha_modificacion: " + today);
        bw.append("\r\n");
        bw.append("usuario_modificacion: " + adminUser);
        bw.append("\r\n");
        bw.append("#_registros: " + info.get(5));
        bw.append("\r\n");
        bw.append("registros_activos: " + activeReg);
        bw.append("\r\n");
        bw.append("registros_inactivos: " + inactReg);
        bw.append("\r\n");
        bw.append("max_reorganizacion: " + info.get(8));
        bw.flush();
        bw.close();
        
        return true;
        
    }
    
    private static boolean CrearBitacoraArchivo(String nombreMaster) 
            throws IOException{
        
        File file  = null;
        String data = "";
        
        data = "C:\\MEIA\\bitacora_" + nombreMaster + ".txt";
        
        file = new File(data);
        
        boolean flag = file.createNewFile();
        
        return flag;
        
    }
    
    /**
     * Recibe el dato a escribir y procesa para que se escriba ya sea en la 
     * bitacora, master y modifica el descriptor
     * @param dato
     * @param nombreMaster
     * @return 
     * @throws java.io.IOException 
     */
    public static boolean Escribir(String dato,String nombreMaster,
            String nombreAdmin)
    throws IOException, NullPointerException{
        
        File tmpDir = new File("C:\\MEIA\\"+ nombreMaster + ".txt");   
        FileWriter fw;
        BufferedWriter bw;
        FileReader fr;
        BufferedReader br;
        
        File bitacora = new File("C:\\MEIA\\bitacora_" + nombreMaster + ".txt");
        
        if (tmpDir.exists()) {
            
            //Lee el descriptor
            File descriptor = new File("C:\\MEIA\\desc_" + nombreMaster + 
                    ".txt");
            List<String> dataDescriptor = new ArrayList<>();
            
            fr = new FileReader(descriptor);
            br = new BufferedReader(fr);
            
            //obtiene todas las lineas del descriptor
            dataDescriptor = br.lines().collect(Collectors.toList());
            
            
            br.close();
            
            //obtiene la posicion de max_organizacion(8) y 
            //numero de registros en la bitacora(5)
            String[] max_reorg = dataDescriptor.get(8).trim().split(":");
            String[] cant_reg = dataDescriptor.get(5).trim().split(":");
            
            if(!cant_reg[1].equals(max_reorg[1]) && 
            Integer.getInteger(cant_reg[1]) < Integer.getInteger(max_reorg[1])){
                
                //se abre un buffer de datos hacia la bitacora
                fw = new FileWriter(bitacora);
                bw = new BufferedWriter(fw);
                
                //se escribe el dato hacia el buffer de bitacora
                bw.append(dato);
                bw.append("\r\n");
                bw.flush();
                bw.close();
                
               
                //actualiza el archivo descriptor
               EscribirArchivoDesc(nombreAdmin, nombreMaster);
                
                        
            }else{
                //se mete todo al archivo Maestro
                Utilidades.BubbleSort(tmpDir, bitacora);
            }
            
        }else{
            throw new IOException("El archivo no existe");
        }
        
        
        return true;
    }
    
    //NotImplemented
    public static boolean Buscar(){
        
        
        return false;
    }
}
    
    
    
