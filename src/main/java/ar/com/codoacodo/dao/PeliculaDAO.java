package ar.com.codoacodo.dao;

import java.util.ArrayList;

import ar.com.codoacodo.domain.Pelicula;

public interface PeliculaDAO {

    public Pelicula getById(Long id);
    public void create(Pelicula PeliculaDto);
    public ArrayList<Pelicula> findAll();
	public void update(Pelicula pelicula);
    public void delete(Long id);
}