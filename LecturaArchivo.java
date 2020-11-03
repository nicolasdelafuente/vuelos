package vuelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LecturaArchivo {
    /**
     * Cambiar ubicacion archivo txt de Aeropuertos y Vuelos
     */
    static String ArchivoDeAeropuertos_TXT = "vuelos/aeropuertos.txt";
    static String ArchivoDeVuelos_TXT = "vuelos/vuelos.txt";
	  private static PriorityQueue<String> pq = new PriorityQueue<>();
	 
    
    //Funcion que llena la PQ desde el archivo aeropuertos.txt
    public void llenarPQAeropuertos() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(ArchivoDeAeropuertos_TXT));
        String line;
        while ((line = in.readLine()) != null) {
            pq.add(line);
        }
        in.close();
    }


    //Lectura de la PQ en forma ordenada
    public void lecturaOrdenada(PriorityQueue<String> pq) {

      Iterator iterator = pq.iterator(); 
  
      while (iterator.hasNext()) { 
          System.out.println(iterator.next()); 
      } 
        // while (!pq.isEmpty()) {
        //     String lineaAMostrar = pq.poll();

        //     System.out.println(lineaAMostrar);
        // }
    }
    //Buscar por codigo IATA
    public void buscarIATA(String codigo) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(ArchivoDeAeropuertos_TXT));
        String lineAComparar;
        boolean encontrado = false;

        while ((lineAComparar = in.readLine()) != null && !encontrado) {
            String siglas = lineAComparar.substring(0,3);
            String[] lineaSeparada = lineAComparar.split("\\s+");
            String nombre = lineaSeparada[1];
            String ciudad = lineaSeparada[2];
            String pais = lineaSeparada[3];
            if(siglas.equals(codigo)){
                System.out.println("EL codigo " + siglas + " corresponde al aeropuerto '" + nombre + "'\n"
                                  + "Ubicado en " + ciudad + ", " + pais);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Codigo IATA no encontrado");
        }
        in.close();
    }


    public void borrarAeropuertoDeArchivo(String ArchivoDeAeropuertos_TXT, String lineToRemove) {

        try {
          File inFile = new File(ArchivoDeAeropuertos_TXT);
          if (!inFile.isFile()) {
            System.out.println("Parameter is not an existing file");
            return;
          }
          // Se construye el nuevo archivo que despues va a ser el renombrado al nombre original
          File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
    
          BufferedReader br = new BufferedReader(new FileReader(ArchivoDeAeropuertos_TXT));
          PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
    
          String line = null;
          //Lee del archivo original y lo escribe al nuevo, 
          //a no ser que encuentre lo que tiene que borrar
          while ((line = br.readLine()) != null) {
            String siglas = line.substring(0,3); 
            if (!siglas.equals(lineToRemove)) {
              pw.println(line);
              pw.flush();
            }
          }
          pw.close();
          br.close();
    
          //Borra el archivo original
          if (!inFile.delete()) {
            System.out.println("No puede borrar el archivo");
            return;
          } 
    
          //Renombra el nuevo Archivo con el nombre original del mismo.
          if (!tempFile.renameTo(inFile))
            System.out.println("No puedo renombrar el archivo");
        }
        catch (FileNotFoundException ex) {
          ex.printStackTrace();
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
    }

    public void borrarAeropuerto(String lineToRemove) {

        try {
          File inFile = new File(ArchivoDeAeropuertos_TXT);
          if (!inFile.isFile()) {
            System.out.println("Parameter is not an existing file");
            return;
          }
          // Se construye el nuevo archivo que despues va a ser el renombrado al nombre original
          File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
    
          BufferedReader br = new BufferedReader(new FileReader(ArchivoDeAeropuertos_TXT));
          PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
    
          String line = null;
          //Lee del archivo original y lo escribe al nuevo, 
          //a no ser que encuentre lo que tiene que borrar
          while ((line = br.readLine()) != null) {
            String siglas = line.substring(0,3); 
            if (!siglas.equals(lineToRemove)) {
              pw.println(line);
              pw.flush();
            }
          }
          pw.close();
          br.close();
    
          //Borra el archivo original
          if (!inFile.delete()) {
            System.out.println("No puede borrar el archivo");
            return;
          } 
    
          //Renombra el nuevo Archivo con el nombre original del mismo.
          if (!tempFile.renameTo(inFile))
            System.out.println("No puedo renombrar el archivo");
        }
        catch (FileNotFoundException ex) {
          ex.printStackTrace();
        }
        catch (IOException ex) {
          ex.printStackTrace();
        }
    }


    public static void darDeAltaAeropuerto(){
          Scanner sn = new Scanner(System.in);

          System.out.print("Codio IATA: ");
          String codigoIATANuevo = sn.next();
          System.out.print("Nombre del aeropuerto: ");
          String nombreAeropuertoNuevo = sn.next();
          System.out.print("Ciudad: ");
          String ciudadNueva = sn.next();
          System.out.print("Pais: ");
          String paisNuevo = sn.next();
          System.out.print("km2: ");
          String km2Nuevo = sn.next();
          System.out.print("Terminales: ");
          String terminalesNuevo = sn.next();
          System.out.print("Vuelos nacionales: ");
          String nacionalesNuevo = sn.next();
          System.out.print("Vuelos internacionales: ");
          String internacionalesNuevo = sn.next();

          String lineaNueva = (codigoIATANuevo + " " + nombreAeropuertoNuevo + " " + ciudadNueva
                              + " " + paisNuevo + " " + km2Nuevo + " " + terminalesNuevo
                              + " " + nacionalesNuevo + " " + internacionalesNuevo);

          try {
              BufferedWriter bw = new BufferedWriter(new FileWriter(ArchivoDeAeropuertos_TXT, true));
              bw.newLine();
              bw.append(lineaNueva);
              bw.close();
          } catch (IOException e) {
              System.out.println(e.getMessage());
          };
          sn.close();
    };

  

  



    public static void main(String[] args) throws IOException {
        LecturaArchivo lecturaArchivo = new LecturaArchivo();
        // Solo imprime el primer elemento sin sacarlo
        // System.out.println(pq.element());
        // Sacar una linea
        // System.out.println(pq.remove());

        lecturaArchivo.llenarPQAeropuertos();
        lecturaArchivo.lecturaOrdenada(pq);
    }
};
