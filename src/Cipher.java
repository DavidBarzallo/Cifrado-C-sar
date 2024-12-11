import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Esta clase crea el alfabeto que se desplazará hacia la derecha y se usará para comparar y reeplazar el texto
 *
 * */
public class Cipher {

    private static final String ALPHABETO = """
            ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\
            ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ\
            !?%$@&*(){};:'\\".,></#-+=""";

    //METODO ENCRIPTAR
    /**
     * Este método desplaza el alfabeto y reemplaza cada letra del nuevo texto con su correspondiente desplazada.
     * @return devuelve el resultado del desplazamiento hacia la derecha.
     * */
    public static String cifrarTexto(String text, int posicion) {
        // Desplazar derecha
        String alfabetoDesplazado = desplazarAlfabeto(posicion, true);
        StringBuilder textoCifrado = new StringBuilder();

        for (char c : text.toCharArray()) {
            int index = ALPHABETO.indexOf(c);
            if (index != -1) {
                textoCifrado.append(alfabetoDesplazado.charAt(index));
            } else {
                textoCifrado.append(c);
            }
        }

        return textoCifrado.toString();
    }

    // METODO DESENCRIPTAR
    /**
     * Este método vuelve el alfabeto a su posición inicial y lo reemplaza, cada letra del texto encriptado con su correspondiente desplazada.
     * @return devuelve una string con el resultado del desplazamiento.
     * */
    public static String descifrarTexto(String text, int posicion) {
        // Desplazar izquierda
        String alfabetoDesplazado = desplazarAlfabeto(posicion, true);
        StringBuilder textoDesencriptado = new StringBuilder();

        // Recorrer el texto
        for (char c : text.toCharArray()) {
            int index = alfabetoDesplazado.indexOf(c);
            if (index != -1) {
                textoDesencriptado.append(ALPHABETO.charAt(index));
            } else {
                textoDesencriptado.append(c);
            }
        }

        return textoDesencriptado.toString();
    }


    private static String desplazarAlfabeto(int posicion, boolean haciaDerecha) {
        int longitud = ALPHABETO.length();
        posicion = posicion % longitud;

        if (!haciaDerecha) {
            posicion = longitud - posicion;
        }

        return ALPHABETO.substring(posicion) + ALPHABETO.substring(0, posicion);
    }

    // guardar el desencriptado en un archivo

    /**
     * Guarda el archivo desencriptado en un archivo.
     * @param  filePath es la ruta donde guardar el archivo.
     *
     * */
    public static void guardarArchivo(String textoDesencriptado, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(textoDesencriptado);
        } catch (IOException e) {
            System.out.println("No se guardó el archivo: " + e.getMessage());
        }
    }
}
