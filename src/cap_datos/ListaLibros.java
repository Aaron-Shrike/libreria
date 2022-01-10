/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_datos;

import cap_logica.Libro;
import cap_logica.TipoArea;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sh
 */
public class ListaLibros {
    private static ArrayList<Libro> datos = new ArrayList<>();
    
    public static void agregar(Libro obj){
        datos.add(obj);
    }
    
    public static ArrayList<Libro> obtener(){
        return datos;
    }
    
    public static Libro buscarLibro(String ISBM){
        Iterator<Libro> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Libro l = it.next();
            
            if(l.getISBN().equalsIgnoreCase(ISBM)){
                    return l;
            }
        }
        return null;
    }
    
    public static int[] cantidadLibrosPorArea(){
        int contador[] = new int[3];
        Iterator<Libro> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Libro l = it.next();
            
            if(l.getAreaTematica()== TipoArea.LETRAS){
                contador[0]++;
            }
            if(l.getAreaTematica()== TipoArea.CIENCIAS){
                contador[1]++;
            }
            if(l.getAreaTematica()== TipoArea.TECNOLOGIA){
                contador[2]++;
            }  
        }
        
        return contador;
    }
    
    public static ArrayList<Libro> librosSegunRango(int año1, int año2){
        ArrayList<Libro> lista = new ArrayList<>();
        Iterator<Libro> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Libro l = it.next();
            
            if(l.getAño() >= año1 && l.getAño() <= año2){
                lista.add(l);
            }
        }
        
        return lista;
    }
    
    public static ArrayList<Libro> librosSegunAutor(String autor){
        ArrayList<Libro> lista = new ArrayList<>();
        Iterator<Libro> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Libro l = it.next();
            
            String aut[] = l.getAutores();
            
            for (int i = 0; i < l.getAutores().length; i++) {
                
                if(aut[i].equalsIgnoreCase(autor)){
                    lista.add(l);
                }
            }
        }
        
        return lista;
    }
}
