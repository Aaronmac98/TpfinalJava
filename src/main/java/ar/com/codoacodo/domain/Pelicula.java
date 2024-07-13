package ar.com.codoacodo.domain;

public class Pelicula {
    private Long id;
    private String titulo;
    private String director;    
    private String añodelanzamiento;
    private String genero;
    

    //Constructores
    public Pelicula(Long id,String titulo,String director,String añodelanzamiento,String genero){
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.añodelanzamiento = añodelanzamiento;
        this.genero = genero;
    }
    
    public Pelicula(String titulo,String director,String añodelanzamiento,String genero){
        this.titulo = titulo;
        this.director = director;
        this.añodelanzamiento = añodelanzamiento;
        this.genero = genero;
    }

    
    //Setters y Getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getAñodelanzamiento() {
        return añodelanzamiento;
    }

    public void setAñodelanzamiento(String añodelanzamiento) {
        this.añodelanzamiento = añodelanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setgenero(String genero) {
        this.genero = genero;
    }

    //toString
    @Override
    public String toString() {
        return "Usuarios [id=" + id + ", Titulo=" + titulo + ", Director=" + director + ", Añodelanzamiento="
                + añodelanzamiento + ", genero=" + genero + "]";
    }


}
