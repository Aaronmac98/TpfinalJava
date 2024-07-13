package ar.com.codoacodo.controller;

import java.io.IOException;

import ar.com.codoacodo.service.PeliculaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarPeliculaController")
public class EliminarPeliculaController extends HttpServlet{
        
        @Override
        protected void doDelete(
            HttpServletRequest req,//aca viene lo del front
            HttpServletResponse resp//aca se manda al front
        ) throws ServletException, IOException {
    
            //capturo el id que viene desde el front
            String id = req.getParameter("id");
    
            PeliculaService service = new PeliculaService();
    
            Long idLong = Long.parseLong(id);
    
            service.eliminar(idLong);
    
            resp.setStatus(HttpServletResponse.SC_OK);
        } 
      
}
