package Modelo;

public class Modelo {

    public static class Director {
        private String nombre;
        private String apellidos;
        private boolean ganadorOscar;

        public Director(String nombre, String apellidos, boolean ganadorOscar) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.ganadorOscar = ganadorOscar;
        }

        public String getNombreCompleto() {
            return nombre + " " + apellidos;
        }

        public boolean esGanadorOscar() {
            return ganadorOscar;
        }
    }


    public static class Pelicula {
        private String titulo;
        private Director director;
        private int anioEstreno;
        private int duracionMinutos;
        private float valoracion;

        public Pelicula(String titulo, Director director, int anioEstreno, int duracionMinutos, float valoracion) {
            this.titulo = titulo;
            this.director = director;
            this.anioEstreno = anioEstreno;
            this.duracionMinutos = duracionMinutos;
            this.valoracion = valoracion;
        }

        public String getTitulo() {
             return titulo; 
            }
        public Director getDirector() { 
            return director; 
        }
        public int getAnioEstreno() {
             return anioEstreno;
             }
        public int getDuracionMinutos() {
             return duracionMinutos;
             }
        public float getValoracion() 
        { return valoracion; 
        }

        public float getTiempoVisionado(float factorVelocidad) {
            if (factorVelocidad <= 0) {
                return duracionMinutos; 
            }
            return duracionMinutos / factorVelocidad;
        }
    }

    public static class Videoteca {
        private Pelicula[] peliculas;
        private int numPeliculasActuales;
       
        public Videoteca(int tamano) {
            this.peliculas = new Pelicula[tamano];
            this.numPeliculasActuales = 0; 
        }

        public boolean anadirPelicula(Pelicula p) {
             if (numPeliculasActuales < peliculas.length) {
                peliculas[numPeliculasActuales] = p; 
                numPeliculasActuales++; 
                return true; 
            } else {
                return false;
            }
        }

        public Pelicula[] getPeliculas() {
            return peliculas;
        }

        public int getNumPeliculasActuales() {
            return numPeliculasActuales;
        }
    }
}

