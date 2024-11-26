import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cipher {

    private static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!?%$@&*(){};:'\\\".,></#-+=- ";

    public static String desplazarAlfabeto(int posicion, boolean haciaDerecha) {
        int longitud = alfabeto.length();
        posicion = posicion % longitud;

        if (!haciaDerecha) {
            posicion = longitud - posicion;
        }

        return alfabeto.substring(posicion) + alfabeto.substring(0, posicion);
    }

    //METODO ENCRIPTAR

    public static String cifrarTexto(String texto, int desplazamiento) {
        // Alfabeto desplazado
        String alfabetoDesplazado = desplazarAlfabeto(desplazamiento, true);

        StringBuilder textoCifrado = new StringBuilder();

        // Recorrer el texto
        for (char c : texto.toCharArray()) {
            int indice = alfabeto.indexOf(c);
            if (indice != -1) {
                textoCifrado.append(alfabetoDesplazado.charAt(indice));
            } else {
                textoCifrado.append(c);
            }
        }
        return textoCifrado.toString();
    }

    // guardar el cifrado en un archivo
    public static void guardarEnArchivo(String textoCifrado, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(textoCifrado);
            System.out.println("El texto cifrado se ha guardado con éxito: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("No se guardó el archivo: " + e.getMessage());
        }
    }


    // METODO DESENCRIPTAR

    public static String desplazarAlfabetoIzquierda(int posicion, boolean haciaDerecha) {
        int longitud = alfabeto.length();
        posicion = (posicion % longitud + longitud) % longitud;

        if (!haciaDerecha) {
            posicion = longitud - posicion;
        }
        return alfabeto.substring(posicion) + alfabeto.substring(0, posicion);
    }


    public static String descifrarTexto(String textoCifrado, int desplazamiento) {

        // Desplazar izquierda
        String alfabetoDesplazado2 = desplazarAlfabetoIzquierda(desplazamiento, true);
        StringBuilder textoDesencriptado = new StringBuilder();

        // Recorrer el texto
        for (char c : textoCifrado.toCharArray()) {
            int indice = alfabetoDesplazado2.indexOf(c);
            if (indice != -1) {
                textoDesencriptado.append(alfabeto.charAt(indice));
            } else {
                textoDesencriptado.append(c);
            }
        }

        return textoDesencriptado.toString();
    }

    // guardar el desencriptado en un archivo
    public static void guardarEnArchivo2(String textoDesencriptado, String rutaDesCifrado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDesCifrado))) {
            writer.write(textoDesencriptado);
            System.out.println("El texto desencriptado se ha guardado con éxito: " + rutaDesCifrado);
        } catch (IOException e) {
            System.out.println("No se guardó el archivo: " + e.getMessage());
        }
    }
}

