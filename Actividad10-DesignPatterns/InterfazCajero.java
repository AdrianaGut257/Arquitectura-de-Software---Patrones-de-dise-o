public class InterfazCajero{
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
