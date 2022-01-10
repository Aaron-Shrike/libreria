/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_presentacion;

import basicas.Consola;
import cap_datos.ListaLibros;
import cap_logica.Libro;
import cap_logica.TipoArea;
import java.util.ArrayList;
import java.util.Iterator;
import menu.Menu;
import menu.Opcion;

/**
 *
 * @author Rojas Vera Aaron
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Consola objConsola = new Consola();
        Menu objMenu = new Menu();
        
        int opcion;
        
        defineMenu(objMenu);
        
        do{
            opcion = objMenu.display();
            
            switch(opcion){
                case 11:
                        Libro objL = new Libro();
                        
                        objL.setISBN(objConsola.leer("Ingrese ISBN : "));
                        objL.setTitulo(objConsola.leer("Ingrese titulo : "));
                        objL.setAño(objConsola.leer("Ingrese año(MAX. 2020) : ",1900,2020));
                        objL.setEditorial(objConsola.leer("Ingrese nombre de la empresa editorial : "));
                        objL.setCantPaginas(objConsola.leer("Ingrese cantidad de paginas(MAX 5000): ",1,5000));
                            int opcArea;
                            TipoArea area = null;
                            
                            System.out.println("[1] " + TipoArea.LETRAS.name());
                            System.out.println("[2] " + TipoArea.CIENCIAS.name());
                            System.out.println("[3] " + TipoArea.TECNOLOGIA.name());
                            
                            opcArea = objConsola.leer("Ingrese area tematica[1-3] : ", 1, 3);
                            
                            switch(opcArea){
                                case 1: area = TipoArea.LETRAS; break;
                                case 2: area = TipoArea.CIENCIAS; break;
                                case 3: area = TipoArea.TECNOLOGIA; break;
                            }
                        objL.setAreaTematica(area);
                        objL.setCosto(objConsola.leer("Ingrese costo(MAX S/.3000): ", 1, 3000));
                            String autores[];
                            int cant;
                            
                            cant = objConsola.leer("Ingrese cantidad de autores(MAX 2): ", 1, 2);
                            
                            autores = new String[cant];
                            
                            for (int i = 0; i < cant; i++) {
                                autores[i] = objConsola.leer("Ingrese autor[" + (i+1) + "]: ");
                            }
                        objL.setAutores(autores);
                        
                        ListaLibros.agregar(objL);
                        
                        System.out.println("\n\t* Libro registrado");
                    break;
                
                case 21:
                        Libro objAux;
                        String auxISBM;
                        int opc;
                        
                        auxISBM = objConsola.leer("Ingrese ISBM a buscar : ");
                        objAux = ListaLibros.buscarLibro(auxISBM);
                        
                        if(objAux != null){
                            System.out.println("[1] ISBM");
                            System.out.println("[2] Titulo");
                            System.out.println("[3] Año");
                            System.out.println("[4] Nombre de la empresa editorial");
                            System.out.println("[5] Cantidad de paginas");
                            System.out.println("[6] Area tematica");
                            System.out.println("[7] Costo");
                            System.out.println("[8] Autores");
                            System.out.println("[9] Cancelar");

                            opc = objConsola.leer("Ingrese opcion a editar : ", 1, 9);

                            switch(opc){
                                case 1: 
                                        objAux.setISBN(objConsola.leer("Ingrese ISBM : "));
                                    break;
                                case 2: 
                                        objAux.setTitulo(objConsola.leer("Ingrese titulo : "));
                                    break;
                                case 3: 
                                        objAux.setAño(objConsola.leer("Ingrese año(MAX 2020) : ",1900,2020));
                                    break;
                                case 4: 
                                        objAux.setEditorial(objConsola.leer("Ingrese nombre de la empresa editorial : "));
                                    break;
                                case 5: 
                                        objAux.setCantPaginas(objConsola.leer("Ingrese cantidad de paginas(MAX 5000) : ",1,5000));
                                    break;
                                    
                                case 6:
                                            int opcA;
                                            TipoArea areaA = null;

                                            System.out.println("[1] " + TipoArea.LETRAS.name());
                                            System.out.println("[2] " + TipoArea.CIENCIAS.name());
                                            System.out.println("[3] " + TipoArea.TECNOLOGIA.name());

                                            opcA = objConsola.leer("Ingrese area tematica[1-3] : ", 1, 3);

                                            switch(opcA){
                                                case 1: areaA = TipoArea.LETRAS; break;
                                                case 2: areaA = TipoArea.CIENCIAS; break;
                                                case 3: areaA = TipoArea.TECNOLOGIA; break;
                                            }
                                        objAux.setAreaTematica(areaA);
                                    break;
                                case 7:
                                        objAux.setCosto(objConsola.leer("Ingrese costo(MAX S/. 3000): ", 1, 3000));
                                    break;
                                case 8:
                                            String autoresAux[];
                                            int cantAux;

                                            cantAux = objConsola.leer("Ingrese cantidad de autores[1-2] : ", 1, 2);

                                            autoresAux = new String[cantAux];

                                            for (int i = 0; i < cantAux; i++) {
                                                autoresAux[i] = objConsola.leer("Ingrese autor[" + i + "]: ");
                                            }
                                        objAux.setAutores(autoresAux);
                                    break;
                            }
                        }else{
                            System.out.println("\n\t* Libro no encontrado");
                        }
                    break;
                    
                case 31:
                        ArrayList<Libro> lista;
                        Iterator<Libro> it;
                        
                        lista = ListaLibros.obtener();
                        
                        System.out.println("LISTADO GENERAL DE LIBROS");
                        
                        if(!lista.isEmpty()){
                            
                            it = lista.iterator();
                            while(it.hasNext()){
                                Libro l = it.next();
                                
                                System.out.println(l.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                case 32:
                        int contadorA[] = ListaLibros.cantidadLibrosPorArea();
                        int total = 0;
                        float porcLetras = 0.0f;
                        float porcCiencias = 0.0f;
                        float porcTecnologia = 0.0f;
                        
                        total += contadorA[0] + contadorA[1] + contadorA[2]; 
                        
                        if(contadorA[0] > 0){
                            porcLetras = total/contadorA[0]*100;
                        }
                        if(contadorA[1] > 0){
                            porcCiencias= total/contadorA[1]*100;
                        }
                        if(contadorA[2] > 0){
                            porcTecnologia = total/contadorA[2]*100;
                        }
                        
                        System.out.println("CANTIDAD DE LIBROS POR AREA TEMATICA");
                        System.out.println(TipoArea.LETRAS.name() + ": " + contadorA[0] + " - " + porcLetras + "%");
                        System.out.println(TipoArea.CIENCIAS.name() + ": " + contadorA[1] + " - " + porcCiencias + "%");
                        System.out.println(TipoArea.TECNOLOGIA.name() + ": " + contadorA[2] + " - " + porcTecnologia + "%");
                    break;
                case 33:
                        ArrayList<Libro> lista1;
                        Iterator<Libro> it1;
                        
                        int año1 = objConsola.leer("Ingrese menor año(MAX 2020) : ", 1900, 2020);
                        int año2 = objConsola.leer("Ingrese mayor año["+año1+"-2020] : ", año1, 2020);
                        
                        lista1 = ListaLibros.librosSegunRango(año1, año2);
                        
                        System.out.println("LISTADO LIBROS(" + año1 + "-" + año2 + ")");
                        
                        if(!lista1.isEmpty()){
                            
                            it1 = lista1.iterator();
                            while(it1.hasNext()){
                                Libro l = it1.next();
                                
                                System.out.println(l.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                case 34:
                        ArrayList<Libro> lista2;
                        Iterator<Libro> it2;
                        
                        String autor = objConsola.leer("Ingrese autor a buscar : ");
                        
                        lista2 = ListaLibros.librosSegunAutor(autor);
                        
                        System.out.println("LISTADO LIBROS(" + autor + ")");
                        
                        if(!lista2.isEmpty()){
                            
                            it2 = lista2.iterator();
                            while(it2.hasNext()){
                                Libro l = it2.next();
                                
                                System.out.println(l.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                
            }
        }while(opcion != 99);
    }
    
    public static void defineMenu(Menu objMenu){
        objMenu.agregar(new Opcion(11,"Registrar Libro"));
        
        objMenu.agregar(new Opcion(21,"Modificar Libro"));
        
        objMenu.agregar(new Opcion(31,"Listado general de libros"));
        objMenu.agregar(new Opcion(32,"Reporte de la cantidad de libros por area tematica"));
        objMenu.agregar(new Opcion(33,"Dado un rango de años, mostrar los libros que estan en rango"));
        objMenu.agregar(new Opcion(34,"Mostrar los libros pertenecientes a un autor ingresado"));
        
        objMenu.agregar(new Opcion(99,"Salir"));
    }
    
}
