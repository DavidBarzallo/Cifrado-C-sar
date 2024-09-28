import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {

    public String leerArchivo(String rutaArchivo) {
        // Leer el archivo en bytes y convertirlo a caracteres
        StringBuilder contenido = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream(rutaArchivo);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado..");
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo..");
        }

        return contenido.toString(); //devolver contenido
    }
}



