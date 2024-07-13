package ar.com.codoacodo.controller;


import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codoacodo.domain.Pelicula;
import ar.com.codoacodo.service.PeliculaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ListarPeliculaController")
public class ListarPeliculaController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       

     //1 crear el service
     PeliculaService service = new PeliculaService();

     //2 ejecuto el metodo
     ArrayList<Pelicula> listado = service.listarPelicula();
     
     ObjectMapper mapper = new ObjectMapper();

     //convierto Objecto java a json string
     //ahora respondo al front: json, Convirtiendo el nuevo Clientes a json
     String PeliculaJSON = mapper.writeValueAsString(listado);
     
     //mostrar por consola|enviar al frontend
     resp.getWriter().println(PeliculaJSON);        

    }
}
