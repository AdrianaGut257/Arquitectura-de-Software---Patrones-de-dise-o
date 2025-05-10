package CajeroBancoPorClasesSeparadas;

import java.util.Scanner;

public class Depositar implements Transaccion {
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Monto a depositar: ");
        int monto = sc.nextInt();
        CajeroBanco.getInstancia().depositar(monto);
        System.out.println("Depósito exitoso. Nuevo saldo: " + CajeroBanco.getInstancia().getSaldo());
    }
}

