package PorClases;

public class Consultar implements Transaccion {
    public void ejecutar() {
        System.out.println("Saldo actual: " + CajeroBanco.getInstancia().getSaldo());
    }
}