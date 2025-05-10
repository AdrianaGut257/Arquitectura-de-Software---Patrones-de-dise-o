package CajeroBancoTodasLasClasesUnidas;
import java.util.Scanner;

// Clase principal Main
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

// Patrón Singleton - Asegura que solo haya una instancia del banco
class CajeroBanco {
    private static CajeroBanco cajeroBanco;
    private int saldo = 1000;

    private CajeroBanco(){
    }

    public static CajeroBanco getInstancia() {
        if(cajeroBanco == null){
            cajeroBanco = new CajeroBanco();
        }
        return cajeroBanco;
    }

    public int getSaldo(){
        return saldo;
    }

    public void depositar(int cantidad){
        saldo += cantidad;
    }

    public boolean retirar(int cantidad){
        boolean respuesta = false;
        if(cantidad <= saldo){
            saldo -= cantidad;
            respuesta= true;
        }else{
            respuesta= false;
        }
        return respuesta;
    } 
}

// Patrón Strategy - Interfaz para operaciones del cajero
interface Transaccion {
    void ejecutar();
}

// Patrón Strategy - Estrategia concreta: Consultar saldo
class Consultar implements Transaccion {
    public void ejecutar() {
        System.out.println("Saldo actual: " + CajeroBanco.getInstancia().getSaldo());
    }
}

// Patrón Strategy - Estrategia concreta: Depositar dinero
class Depositar implements Transaccion {
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Monto a depositar: ");
        int monto = sc.nextInt();
        CajeroBanco.getInstancia().depositar(monto);
        System.out.println("Depósito exitoso. Nuevo saldo: " + CajeroBanco.getInstancia().getSaldo());
    }
}

// Patrón Strategy - Estrategia concreta: Retirar dinero
class Retirar implements Transaccion{
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Monto a retirar: ");
        int monto = sc.nextInt();
        if(CajeroBanco.getInstancia().retirar(monto)){
            System.out.println("Retiro exitoso. Nuevo saldo: " + CajeroBanco.getInstancia().getSaldo());
        }else{
            System.out.println("Fondos insuficientes.");
        }
    }
}

// Patrón Facade - Proporciona una interfaz unificada para el cajero
class InterfazCajero{
    public void realizarOperacion(int opcion){
        Transaccion operacion = null;
        switch (opcion){
            case 1:
                operacion = new Consultar();
                break;
            case 2:
                operacion = new Depositar();
                break;
            case 3:
                operacion = new Retirar();
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        operacion.ejecutar();
    }
}

