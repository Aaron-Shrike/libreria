/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_logica;

/**
 *
 * @author Sh
 */
public class Libro implements Presentable{
    private String ISBN;
    private String titulo;
    private int año;
    private String editorial;
    private int cantPaginas;
    private TipoArea areaTematica;
    private double costo;
    private String autores[];

    public Libro() {
        this.ISBN = "";
        this.titulo = "";
        this.año = 0;
        this.editorial = "";
        this.cantPaginas = 0;
        this.areaTematica = null;
        this.costo = 0.0;
        this.autores = null;
    }
    
    public Libro(String ISBN, String titulo, int año, String editorial, int cantPaginas, TipoArea areaTematica, double costo, String[] autores) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.año = año;
        this.editorial = editorial;
        this.cantPaginas = cantPaginas;
        this.areaTematica = areaTematica;
        this.costo = costo;
        this.autores = autores;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public TipoArea getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(TipoArea areaTematica) {
        this.areaTematica = areaTematica;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    @Override
    public String presentarLineal() {
        String txt;
        
        txt = ISBN + "\t" + titulo + "\t" + año + "\t" + editorial + "\t" + cantPaginas+ "\t" + areaTematica.name() + "\t" + costo + "\t";
    
        for (int i = 0; i < autores.length; i++) {
            txt += autores[i] + " - ";
        }
        
        return txt;
    }

    @Override
    public String presentarDetalle() {
        String txt;
        
        txt = "ISBM: " + ISBN + 
                "\nTitulo: " + titulo + 
                "\nAño: " + año + 
                "\nEmpresa editorial: " + editorial + 
                "\nCantidad de paginas: " + cantPaginas+ 
                "\nArea tematica: " + areaTematica.name() + 
                "\nCosto: " + costo + 
                "\nAutores: ";
        
        for (int i = 0; i < autores.length; i++) {
            txt += "\n\tAutor[" + i + "]: " + autores[i];
        }
        
        return txt;
                
    }
}
