package CajeroBancoPorClasesSeparadas;

public class CajeroBanco {
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