package Modelo;
import java.util.ArrayList;

public  class Modelo {
    public static class Videoteca{
        static ArrayList<Pelicula> peliculas;
        
        public void ConstuctorVideoteca(int numPeliculas){
        Videoteca.peliculas = new ArrayList<Pelicula>(numPeliculas);
     }
    }
    
    public static class Pelicula{
        String titulo;
        String director;
        int añoEstreno;
        int duracionMinutos;
        String valoracion;
    }
    public static class Director{
        String nombre,apellidos;
        boolean ganadorOscar;
    }
}
