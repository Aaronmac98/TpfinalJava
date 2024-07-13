package ar.com.codoacodo.controller;

import ar.com.codoacodo.domain.Pelicula;
import ar.com.codoacodo.service.PeliculaService;


public class ObtenerPeliculaController {
    public static void main(String[] args) {

        Long id = 1l;

        PeliculaService service = new PeliculaService();

        Pelicula pelicula = service.obtener(id);

        //mapper > Pelicula > PeliculaDTO: TPH
        System.out.println(pelicula);
    }
}
