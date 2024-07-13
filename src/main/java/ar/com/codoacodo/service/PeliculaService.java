package ar.com.codoacodo.service;

import java.util.ArrayList;

import ar.com.codoacodo.dao.PeliculaDAO;
import ar.com.codoacodo.dao.PeliculaJDBCMysqlImpl;
import ar.com.codoacodo.domain.Pelicula;
import ar.com.codoacodo.dto.PeliculaDTO;

public class PeliculaService {
    
    private PeliculaDAO dao;

    public PeliculaService() {
        //Interface i = new ClaseQueImplementaLaInterface();
        this.dao = new PeliculaJDBCMysqlImpl();
    }

    public Pelicula obtener(Long id) {
        return this.dao.getById(id);
    }

    public void crear(PeliculaDTO dto) {

        Pelicula pelicula = new Pelicula(
            dto.getTitulo(), 
            dto.getDirector(),            
            dto.getAñodelanzamiento(),
            dto.getGenero());

        this.dao.create(pelicula);
    }

    public ArrayList<Pelicula> listarPelicula() {
        return this.dao.findAll();
    }

    public void actualizar(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula(
            dto.getId(),
            dto.getTitulo(), 
            dto.getDirector(),            
            dto.getAñodelanzamiento(),
            dto.getGenero());
        this.dao.update(pelicula);
    }

    public void eliminar(Long id) {
       this.dao.delete(id);
    }
}
