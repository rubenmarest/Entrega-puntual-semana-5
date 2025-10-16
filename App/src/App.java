import Modelo.Modelo;
import Modelo.Modelo.Pelicula;

import java.util.Scanner;
import java.util.ArrayList;



public class App {
    

    public static void Menu() {
        
        System.out.println("|----------------------------------------------|");
        System.out.println("| MI VIDEOTECA                                 |");
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1)  Nueva videoteca de películas             |");
        System.out.println("| 2)  Configurar velocidad de reproducción     |");
        System.out.println("| 3)  Añadir una nueva película a la videoteca |");
        System.out.println("| 4)  Mostrar información actual de películas  |");
        System.out.println("| 5)  Salir (se borrará toda la información)   |");
        System.out.println("|----------------------------------------------|");
        System.out.print("Seleccione una opción (1-5): ");
    }
    public static void main(String[] args) throws Exception {
    int opcion,numPeliculas;
    float factorX=1.0f;
    char oscar=0;
    Scanner sc= new Scanner(System.in);
    do{
        Menu();
        
        opcion = sc.nextInt();
        if(opcion<1 || opcion>5){
            System.out.println("Opción no válida, seleccione una opción entre 1 y 5.");
        }
   
    switch (opcion) {
        case 1:
            System.out.print("Inserte el numero de peliculas: ");
            numPeliculas = sc.nextInt();
            new Modelo.Videoteca().ConstuctorVideoteca(opcion);;
            break;
        case 2:
        do{    
        System.out.print("Inserte el factor de velocidad (o,25-2,25): ");
            factorX = sc.nextFloat();
            if(factorX<0.25 || factorX>2.5){
                System.out.println("Opción no válida, seleccione una opción entre 0,25 y 2,5");
            }else{
                System.out.println("Velocidad de reproducción configurada a: " + factorX + "x");
            }
            
        }while(factorX<0.25 || factorX>2.5);
        break;
        case 3:
            sc.nextLine();
            Pelicula peli =new Modelo.Pelicula();
            System.out.println("Añadir una nueva película a la videoteca");
            System.out.println("Titulo: ");
            peli.titulo=sc.nextLine();
            System.out.println("Director: ");
            peli.director=new Modelo.Director();
            peli.director.nombre=sc.nextLine();
            do{
            System.out.println("Indique 1 si ha ganado un Oscar y 0 de lo contrario: ");
             oscar = sc.nextLine().charAt(0);
            }while(oscar!='0' && oscar!='1');
            peli.director.ganadorOscar= parseInt(oscar)==1;
            System.out.println("Año de estreno: ");
            peli.añoEstreno=sc.nextInt();
            System.out.println("Duración en minutos: ");
            peli.duracionMinutos=sc.nextInt();
            sc.nextLine();
            System.out.println("Valoracion: ");
            peli.valoracion=sc.nextLine();
            System.out.println("Película añadida correctamente.");

            break;
    
        default:
            break;
    }
    }while(opcion!='5');
    }
}

