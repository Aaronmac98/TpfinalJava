package ar.com.codoacodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codoacodo.domain.Pelicula;

public class PeliculaJDBCMysqlImpl implements PeliculaDAO{

    @Override
    public Pelicula getById(Long id) {        
        String sql = "SELECT * FROM peliculas WHERE id = "+id;

        Pelicula pelicula = null;
        Connection connection = null;
        try{
            //Conexion a la base
            connection = AdministradorDeConexiones.conectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            if(resultset.next()) {
                Long id_usr = resultset.getLong(1);
                String Titulo = resultset.getString(2);
                String Director = resultset.getString(3);
                String Añodelazamiento = resultset.getString(4);
                String Genero = resultset.getString(5);
                
                pelicula = new Pelicula(id_usr, Titulo, Director, Añodelazamiento, Genero);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradorDeConexiones.desconectar(connection);
        }
        return pelicula;
    }

    @Override
    public void create(Pelicula PeliculaDto) {
        String sql = "INSERT INTO peliculas (Titulo, Director, `Año de lanzamiento`, genero) values(?,?,?,?)";
        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, PeliculaDto.getTitulo());
            pst.setString(2, PeliculaDto.getDirector());
            pst.setString(3, PeliculaDto.getAñodelanzamiento ());
            pst.setString(4, PeliculaDto.getGenero());
            
            pst.executeUpdate();
            if(pst.getUpdateCount() > 0) {
                System.out.println("Pelicula Agregada Correctamente!!");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }        
    }

    @Override
    public ArrayList<Pelicula> findAll() {
        
        String sql = "SELECT * FROM peliculas"; 

        ArrayList<Pelicula> listaDePelicula = new ArrayList<>();
        Connection connection = null;
        try{
            
            connection = AdministradorDeConexiones.conectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()) {
                Long id = resultset.getLong(1);
                String Titulo = resultset.getString(2);
                String Director = resultset.getString(3);
                String Añodelazamiento = resultset.getString(4);
                String Genero = resultset.getString(5);
                

                Pelicula unaPelicula = new Pelicula(id, Titulo, Director, Añodelazamiento, Genero);
                listaDePelicula.add(unaPelicula);
            }
        }catch(Exception e) {
            System.err.println(e);
        } finally {
            //siempre: cierro conexion
            AdministradorDeConexiones.desconectar(connection);
        }

        return listaDePelicula;
    }

    @Override
    public void update(Pelicula pelicula) {
        String sql = "UPDATE peliculas SET Titulo = ?, Director = ?, `Año de lanzamiento` = ?, Genero = ? WHERE id = ?";

        Connection connection = AdministradorDeConexiones.conectar();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, pelicula.getTitulo());
            pst.setString(2, pelicula.getDirector());
            pst.setString(3, pelicula.getAñodelanzamiento());
            pst.setString(4, pelicula.getGenero());
            
            pst.setLong(5, pelicula.getId());

            pst.executeUpdate();
            if(pst.getUpdateCount() > 0) {
                System.out.println("La Pelicula se Actualizo correctamente");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            AdministradorDeConexiones.desconectar(connection);
        }    
    }

    @Override
    public void delete(Long id) {
       
        String sql = "DELETE FROM peliculas where id = ?";
    
        Connection connection = AdministradorDeConexiones.conectar();
    
            try {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setLong(1, id);
    
                pst.executeUpdate();
                if(pst.getUpdateCount() == 0) {
                    throw new RuntimeException("No se pudo eliminar la Pelicula");
                }
            }catch(Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                AdministradorDeConexiones.desconectar(connection);
            } 
    }
    
}
