import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Alphabet
    private static final String ALPHABET = "our alphabet will be here";

    // Methods for encryption, decryption, brute force, statistical analy
    public void encrypt(String inputFile, String outputFile, int key) {
// Implement encryption
    }

    public void decrypt(String inputFile, String outputFile, int key) {
// Implement decryption
    }

    public void bruteForce(String inputFile, String outputFile, String optionalSampleFile) {
// Implementation of brute force
    }

    public void statisticalAnalysis(String inputFile, String outputFile, String optionalSampleFile) {
// Implement statistical analysis
    }

    public static void main(String[] args) {

        Cipher cipher;
        cipher = new Cipher();

//        MENU

        System.out.println("\nHOLA WELCOME TO CESAR\n\n Por favor escoge una opción del menú >>\n");

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println(" 1. Encryption");
            System.out.println(" 2. Decryption with key");
            System.out.println(" 3. Brute force");
            System.out.println(" 4. Statistical analysis");
            System.out.println(" 0. Exit");
            System.out.println();
            System.out.print("===");
            System.out.print(" Select an option ");
            System.out.print("===");
            System.out.println();

            int opcion = scanner.nextInt();
            scanner.nextLine();  // ousar nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("--------------------------- " );
                    System.out.println("Escogió: Encryption " );
                    System.out.println("--------------------------- " );
                    System.out.println(" " );
                    break;

                case 2:
                    System.out.println("--------------------------- " );
                    System.out.println("Escogió: Decryption with key " );
                    System.out.println("--------------------------- " );
                    System.out.println(" " );;
                    break;

                case 3:
                    System.out.println("--------------------------- " );
                    System.out.println("Escogió: Brute force " );
                    System.out.println("--------------------------- " );
                    System.out.println(" " );
                    break;

                case 4:
                    System.out.println("--------------------------- " );
                    System.out.println("Escogió: Statistical Analisys " );
                    System.out.println("--------------------------- " );
                    System.out.println(" " );
                    break;

                case 0:
                    System.out.println("--------------------------- " );
                    System.out.println("Escogió: Exit ... " );
                    System.out.println("--------------------------- " );
                    System.out.println(" " );
                    break;

                default:
                    System.out.println("--------------------------- " );
                    System.out.println("Invalid option, please try again.");
                    System.out.println("--------------------------- " );
                    System.out.println(" " );
            }
        }

        scanner.close();
    }
}
