package br.com.modelo;

public class Livro {
    private int id;
    private String titulo;
    private String sinopse;
    private int idCategoria;
    private int idAutor;
    private double  valor;
    private String nomeCategoria;
    private String nomeAutor;


    // Construtores
    public Livro() {}
    
    public Livro(int id, String titulo, String sinopse, int idCategoria, int idAutor, double valor) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
        this.valor = valor;
    }

    // Getters e Setters
    public int getId() { 
        return id; }
    
    public void setId(int id) { 
        this.id = id; }

    public String getTitulo() { 
        return titulo; }
    
    public void setTitulo(String titulo) { 
        this.titulo = titulo; }

    public String getSinopse() {
        return sinopse; }
   
    public void setSinopse(String sinopse) { 
        this.sinopse = sinopse; }

    public int getIdCategoria() { 
        return idCategoria; }
   
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria; }

    
    public int getIdAutor() { 
        return idAutor; }
    
    public void setIdAutor(int idAutor) { 
        this.idAutor = idAutor; }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

 
    
    
}
