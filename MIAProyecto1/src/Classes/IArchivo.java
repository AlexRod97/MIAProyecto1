/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Bryan Mejía
 */
public interface IArchivo {
    
    /**
     *
     * @param datos
     * @param Archivo
     */
    public abstract boolean EscribirDatos(String datos, File Archivo) 
            throws IOException;
    
    public abstract List<String> ObtenerDatos() 
            throws ArrayIndexOutOfBoundsException;
    
    public abstract boolean CrearArchivo() throws IOException;
    
    public abstract boolean CerrarArchivo() throws IOException;
}
