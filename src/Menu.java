import java.util.Scanner;

public class Menu {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Cipher cipher = new Cipher();
        boolean salir = false;

        while (!salir) {
            System.out.println("Menu:");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption with key");
            System.out.println("3. Brute force");
            System.out.println("4. Statistical analysis");
            System.out.println("0. Exit");
            System.out.println();
            System.out.println("|||||||||||||||||||||");
            System.out.print("Please select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("--------------------------- ");
                    System.out.println("Escogió: Encryption ");
                    System.out.println("--------------------------- ");
                    System.out.println();

                    System.out.print("Introduce el número de desplazamiento: ");
                    int desplazamiento = scanner.nextInt();
                    FileManager fileManager = new FileManager();
                    String ruta = "/Users/tesseract/Desktop/CURSOS/JAVA/MODULO1/PROYECTO-FINAL/Cesar/files/texto1.txt";
                    String rutaCifrado = "/Users/tesseract/Desktop/CURSOS/JAVA/MODULO1/PROYECTO-FINAL/Cesar/files/texto_cifrado.txt";
                    String contenidoArchivo = fileManager.leerArchivo(ruta);
                    String textoCifrado = Cipher.cifrarTexto(contenidoArchivo, desplazamiento);

                    Cipher.guardarEnArchivo(textoCifrado, rutaCifrado);

                    System.out.println("--------------------------- ");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("--------------------------- ");
                    System.out.println("Escogió: Decryption with key ");
                    System.out.println("--------------------------- ");
                    System.out.println();

                    System.out.print("Introduce la clave de desplazamiento: ");
                    int desplazamientoIzquierda = scanner.nextInt();
                    fileManager = new FileManager();
                    rutaCifrado = "/Users/tesseract/Desktop/CURSOS/JAVA/MODULO1/PROYECTO-FINAL/Cesar/files/texto_cifrado.txt";
                    String contenidoArchivoCifrado = fileManager.leerArchivo(rutaCifrado);
                    String rutaDesCifrado = "/Users/tesseract/Desktop/CURSOS/JAVA/MODULO1/PROYECTO-FINAL/Cesar/files/texto_decifrado.txt";

                    String textoDesencriptado = Cipher.descifrarTexto(contenidoArchivoCifrado, desplazamientoIzquierda);
                    Cipher.guardarEnArchivo2(textoDesencriptado, rutaDesCifrado);
                    break;
                case 3:
                    System.out.println("--------------------------- ");
                    System.out.println("Escogió: Brute force ");
                    System.out.println("--------------------------- ");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("--------------------------- ");
                    System.out.println("Escogió: Statistical Analisys ");
                    System.out.println("--------------------------- ");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("--------------------------- ");
                    System.out.println("Escogió: Exit ... ");
                    System.out.println("--------------------------- ");
                    System.out.println();
                    break;
                default:
                    System.out.println("--------------------------- ");
                    System.out.println("Invalid option, please try again.");
                    System.out.println("--------------------------- ");
                    System.out.println();
            }
        }
        while (option != 0) ;
        {
            scanner.close();
        }
    }
}


