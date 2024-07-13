package ar.com.codoacodo.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import ar.com.codoacodo.dto.PeliculaDTO;
import ar.com.codoacodo.service.PeliculaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/CrearPeliculaController")
public class CrearPeliculaController extends HttpServlet {

    protected void doPost(
        HttpServletRequest req,//aca viene todo desde el front
        HttpServletResponse resp//aca respondemos al front
    ) throws ServletException, IOException {

        
        String json = req.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
            
        
        ObjectMapper mapper = new ObjectMapper();

        PeliculaDTO peliculaDto = mapper.readValue(json, PeliculaDTO.class);

        PeliculaService service = new PeliculaService();

        System.out.println(peliculaDto);

        service.crear(peliculaDto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}
