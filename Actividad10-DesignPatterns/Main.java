import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        InterfazCajero cajero = new InterfazCajero();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n--- Cajero Automático ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Eliga una opción: ");
            int opcion = sc.nextInt();

            if(opcion == 4){
                System.out.println("Gracias por usar el cajero.");
                break;
            }
            cajero.realizarOperacion(opcion);
        }
        // Ctrl + f5 para ejecutar
    }
}
