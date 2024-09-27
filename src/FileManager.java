import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileManager {
    public static void main(String[] args) {
        // Rutas de los archivos
        String entrada = "/Users/tesseract/Desktop/CURSOS/JAVA/MODULO1/PROYECTO FINAL/Cesar/files/texto2.txt";
        File destino = new File("texto2.txt");
        String rutaDestino = destino.getAbsolutePath();

        // Leer el archivo en bytes y convertirlo a caracteres
        try (FileInputStream inputStream = new FileInputStream(entrada);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//             FileReader fileReader = new FileReader(entrada, StandardCharsets.UTF_8;
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){

//            System.out.println("Printing inputStream ------------");

//            while (inputStream.available() > 0) {
//                char byteLeido = (char)inputStream.read();
////                System.out.println(byteLeido);
//            }

//            System.out.println("Printing inputStreamReader ------------");
//            char[] buffer = new char[30720]; // array para almacenar archivo de texto
//            while(inputStreamReader.ready()){
//                inputStreamReader.read(buffer);
//                char caracter = (char)inputStreamReader.read();
//
//            }

//            System.out.println(Arrays.toString(buffer));
//
//            System.out.println("Printing filereader ------------");
//            while (fileReader.ready()){
//                System.out.println((char)fileReader.read());
//            }


            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());

            }

//            String frase = scanner.nextLine;
        }

         catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } catch (IOException e) {
            System.out.println("Can't read file..");
        }


    }
}

