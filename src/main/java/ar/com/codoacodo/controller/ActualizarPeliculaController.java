package ar.com.codoacodo.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codoacodo.domain.Pelicula;
import ar.com.codoacodo.dto.PeliculaDTO;
import ar.com.codoacodo.service.PeliculaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ActualizarPeliculaController")
public class ActualizarPeliculaController extends HttpServlet {
    @Override
    protected void doPut(
        HttpServletRequest req, // acá viene todo desde el front
        HttpServletResponse resp // acá respondemos al front
    ) throws ServletException, IOException {

        // Leer el JSON enviado en el cuerpo de la solicitud
        String json = req.getReader()
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        // Convertir el JSON a un objeto UsuariosDTO
        ObjectMapper mapper = new ObjectMapper();
        PeliculaDTO peliculaDto = mapper.readValue(json, PeliculaDTO.class);

        // Crear una instancia del servicio de usuarios
        PeliculaService service = new PeliculaService();

        // Imprimir el usuario DTO recibido
        System.out.println(peliculaDto);

        // Actualizar el usuario
        service.actualizar(peliculaDto);

        // Obtener el usuario actualizado y enviarlo de vuelta como respuesta
        Pelicula actualizado = service.obtener(peliculaDto.getId());
        String jsonResponse = mapper.writeValueAsString(actualizado);

        // Configurar la respuesta
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write(jsonResponse);
    }
}
