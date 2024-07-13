package ar.com.codoacodo.dto;

public class PeliculaDTO {
    private Long id;
    private String titulo;
    private String director;
    private String añodelanzamiento;
    private String genero;

    //Constuctores
    public PeliculaDTO(){

    }

    public PeliculaDTO(Long id, String titulo, String director, String añodelanzamiento, String genero){
        this.id = id;
        this.titulo = titulo;
        this.director =director;
        this.añodelanzamiento = añodelanzamiento;
        this.genero = genero;
    }

    public PeliculaDTO(String titulo, String director, String añodelanzamiento, String genero){        
        this.titulo = titulo;
        this.director = director;
        this.añodelanzamiento = añodelanzamiento;
        this.genero = genero;
    }


    
    //Setter y Getters
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

    public void setGenero(String genero) {
        this.genero = genero;
    }


    //toString
    
    @Override
    public String toString() {
        return "PeliculaDTO [id=" + id + ", titulo=" + titulo + ", director=" + director + ", añodelanzamiento="
                + añodelanzamiento + ",genero=" + genero + "]";
    }

}

