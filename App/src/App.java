import Modelo.Modelo;
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
            System.out.println("Añadir una nueva película a la videoteca");

            break;
    
        default:
            break;
    }
    }while(opcion!='5');
    }
}

