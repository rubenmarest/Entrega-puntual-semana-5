import Modelo.Modelo.Director;
import Modelo.Modelo.Pelicula;
import Modelo.Modelo.Videoteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void Menu() {
        System.out.println("\n|----------------------------------------------|");
        System.out.println("| MI VIDEOTECA                                 |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1) Nueva videoteca de películas              |");
        System.out.println("| 2) Configurar velocidad de reproducción      |");
        System.out.println("| 3) Añadir una nueva película a la videoteca  |");
        System.out.println("| 4) Mostrar información actual de películas   |");
        System.out.println("| 5) Salir (se borrará toda la información)    |");
        System.out.println("|----------------------------------------------|");
        System.out.print("Seleccione una opción (1-5): ");
    }


    public static void mostrarInformacionVideoteca(Videoteca videoteca, float factorVelocidad) {
        int numPeliculasActuales = videoteca.getNumPeliculasActuales();
        Pelicula[] peliculas = videoteca.getPeliculas();

        if (numPeliculasActuales == 0) {
            System.out.println("\nLa videoteca está vacía. Añade alguna película primero.");
            return;
        }

        float tiempoTotal = 0;
        float valoracionSuma = 0;

        System.out.println("\n|-----------------------------------------------------------------------------------------------------------------|");
        System.out.println("| PELICULAS EN LA VIDEOTECA                                                                                       |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| %-25s | %-12s | %-20s | %-12s | %-15s | %-20s | %-10s |\n", "Título", "Año Estreno", "Director", "Oscar Ganado", "Duración (min)", "Tiempo Visionado (min)", "Valoración");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------|");

        for (int i = 0; i < numPeliculasActuales; i++) {
            Pelicula p = peliculas[i];
            Director d = p.getDirector();
            float tiempoVisionado = p.getTiempoVisionado(factorVelocidad);

            System.out.printf("| %-25s | %-12d | %-20s | %-12s | %-15d | %-20.2f | %-10.1f |\n",
                    p.getTitulo(),
                    p.getAnioEstreno(),
                    d.getNombreCompleto(),
                    d.esGanadorOscar() ? "Sí" : "No",
                    p.getDuracionMinutos(),
                    tiempoVisionado,
                    p.getValoracion());

            tiempoTotal += tiempoVisionado;
            valoracionSuma += p.getValoracion();
        }

        System.out.println("|-----------------------------------------------------------------------------------------------------------------|");
        System.out.printf("\nTiempo de visionado total de la videoteca: %.2f min\n", tiempoTotal);

        if (numPeliculasActuales > 0) {
            float valoracionMedia = valoracionSuma / numPeliculasActuales;
            System.out.printf("Valoración media de la videoteca: %.2f\n\n", valoracionMedia);
        }
    }


    public static void main(String[] args) throws Exception {
        int opcion = 0;
        float factorX = 1.0f;
        Scanner sc = new Scanner(System.in);

        Videoteca miVideoteca = null;

        do {
            Menu();
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opción no válida, seleccione una opción entre 1 y 5.");
                }

                switch (opcion) {
                    case 1:
                        System.out.print("Inserte el número de películas que cabrán en la videoteca: ");
                        int numPeliculas = sc.nextInt();
                        miVideoteca = new Videoteca(numPeliculas);
                        System.out.println("Videoteca creada con capacidad para " + numPeliculas + " películas.");
                        break;
                    case 2:
                        do {
                            System.out.print("Inserte el factor de velocidad (0,25-2,5): ");
                            if (sc.hasNextFloat()) {
                                factorX = sc.nextFloat();
                                if (factorX < 0.25 || factorX > 2.5) {
                                    System.out.println("Opción no válida, seleccione una opción entre 0,25 y 2,5");
                                } else {
                                    System.out.println("Velocidad de reproducción configurada a: " + factorX + "x");
                                }
                            } else {
                                System.out.println("Entrada no válida, por favor introduzca un número.");
                                sc.next(); 
                                factorX = 0; 
                            }
                        } while (factorX < 0.25 || factorX > 2.5);
                        break;
                    case 3:
                        if (miVideoteca == null) {
                            System.out.println("ERROR: Primero debe crear la videoteca (opción 1).");
                            break;
                        }

                        sc.nextLine(); 
                        System.out.println("\n--- Añadir una nueva película ---");

                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Nombre del director: ");
                        String nombreDirector = sc.nextLine();
                        
                        System.out.print("Apellidos del director: ");
                        String apellidosDirector = sc.nextLine();

                        char oscarChar;
                        do {
                            System.out.print("¿El director ha ganado un Oscar? (s/n): ");
                            oscarChar = sc.next().toLowerCase().charAt(0);
                        } while (oscarChar != 's' && oscarChar != 'n');
                        boolean ganadorOscar = (oscarChar == 's');

                        System.out.print("Año de estreno: ");
                        int anio = sc.nextInt();

                        System.out.print("Duración en minutos: ");
                        int duracion = sc.nextInt();

                        System.out.print("Valoración (0.0 - 10.0): ");
                        float valoracion = sc.nextFloat();

                        Director director = new Director(nombreDirector, apellidosDirector, ganadorOscar);
                        Pelicula peli = new Pelicula(titulo, director, anio, duracion, valoracion);
                        
                        if (miVideoteca.anadirPelicula(peli)) {
                            System.out.println("Película '" + titulo + "' añadida correctamente.");
                        } else {
                            System.out.println("La videoteca está llena, no se pudo añadir la película.");
                        }
                        sc.nextLine();
                        break;
                    case 4:
                        if (miVideoteca == null) {
                            System.out.println("ERROR: Primero debe crear la videoteca (opción 1).");
                            break;
                        }
                        
                        mostrarInformacionVideoteca(miVideoteca, factorX);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa. ¡Hasta pronto!");
                        break;
                }
            } else {
                System.out.println("Error: Por favor, introduce un número válido para la opción.");
                sc.next(); 
                opcion = 0; 
            }
        } while (opcion != 5);
        sc.close();
    }
}

