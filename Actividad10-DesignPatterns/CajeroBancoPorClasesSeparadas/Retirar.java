package CajeroBancoPorClasesSeparadas;

import java.util.Scanner;

public class Retirar implements Transaccion{
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
