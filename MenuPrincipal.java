package vuelosPQ;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MenuPrincipal {
    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void pressEnterParaMenu() {
        System.out.println("Presiona ENTER para volver a Menu...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public void menu() throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; // Guardaremos la opcion que tipea el usuario
        PriorityQueue<String> pq = new PriorityQueue<>();
        LecturaArchivo lecturaArchivo = new LecturaArchivo();
        lecturaArchivo.llenarPQAeropuertos();

        while (!salir) {
            System.out.println("=======================");
            System.out.println("= Menu de Aeropuertos =");
            System.out.println("=======================");
            System.out.println("1. Ver Aeropuerto");
            System.out.println("2. Dar de alta aeropuerto");
            System.out.println("3. Dar de baja aeropuerto");
            System.out.println("4. Mostrar todos los aeropuertos (ordenados por código IATA)");
            System.out.println("5. Busqueda de vuelos por ruta mas corta");
            System.out.println("6. Busqueda de vuelos por ruta mas barata");
            System.out.println("7. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el codigo IATA a buscar: ");
                        String codigoIATAaBuscar = sn.next();
                        lecturaArchivo.buscarIATA(codigoIATAaBuscar);
                        pressEnterParaMenu();
                        clearScreen();
                        break;
                    case 2:
                        System.out.println("Ingrese los datos correspondientes al nuevo Aeropuerto:");
                        LecturaArchivo.darDeAltaAeropuerto();
                        pressEnterParaMenu();
                        clearScreen();
                        break;
                    case 3:
                        System.out.println("Elija el Codigo IATA del aeropuerto a borrar");
                        String codigoIATAaBorrar= sn.next();
                        lecturaArchivo.borrarAeropuerto(codigoIATAaBorrar);
                        pressEnterParaMenu();
                        clearScreen();
                        break;
                    case 4:
                        System.out.println("La lista completa ordenada es:");
                        //lecturaArchivo.llenarPQAeropuertos();
                        // lecturaArchivo.lecturaOrdenada(pq);
                        
                        Iterator iterator = pq.iterator(); 
  
                        while (iterator.hasNext()) { 
                            System.out.println(iterator.next()); 
                        } 

                        
                        //pressEnterParaMenu();
                        //clearScreen();
                        break;
                    case 5:
                        System.out.println("5. Busqueda de vuelos por ruta mas corta");    

                        pressEnterParaMenu();
                        clearScreen();
                        break;
                    case 6:
                        System.out.println("6. Busqueda de vuelos por ruta mas barata");    

                        pressEnterParaMenu();
                        clearScreen();
                        break;
                    case 7:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 7");
                        pressEnterParaMenu();
                        clearScreen();
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                pressEnterParaMenu();
                clearScreen();
                sn.next();
            }
        }
        sn.close();
    }

    public static void main(String[] args) throws IOException {

    }
}