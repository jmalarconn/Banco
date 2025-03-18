import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int op;
        double monto;
        boolean estado = true;


        List<CuentaBancaria> lstBanco = new ArrayList<>(); // creo una lista para ordenar las cuentas

        CuentaBancaria cl1 = CuentaBancaria.obtenerInstancia();
        do {
            System.out.println("""
                    1. CREAR CLIENTE
                    2. MOSTRAR CLIENTES
                    3. MOSTRAR INFORMACION DE CUENTA ESPECIFICA
                    4. DEPOSITAR DINERO
                    5. RETIRAR DINERO
                    6. SALIR""");
            op = teclado.nextInt();

            switch (op) {
                case 1 -> {       //Crear las cuentas con nombre, saldo y número
                    System.out.println("INGRESE NOMBRE DEL TITULAR");
                    cl1.setTitular(teclado.next());   //
                    System.out.println("INGRESE SALDO DE LA CUENTA");
                    cl1.setSaldo(teclado.nextDouble());
                    System.out.println("INGRESE EL NUMERO DE CUENTA");
                    cl1.setNumeroCuenta(teclado.nextInt());


                    lstBanco.add(new CuentaBancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta()));
                }
                case 2 -> {     // revisar los datos de las cuentas
                    for (CuentaBancaria cu : lstBanco) {
                        System.out.println(lstBanco);
                    }
                }
                case 3 -> {    //revisar datos de las cuentas individualmente
                    String Ncuenta;
                    System.out.println("INGRESE TITULAR DE CUENTA");
                    Ncuenta = teclado.next();
                    for (int i = 0; i < lstBanco.size(); i++) {
                        if (lstBanco.get(i).getTitular().equalsIgnoreCase(Ncuenta)) {
                            System.out.println(lstBanco.get(i));
                        }
                    }
                }
                case 4 -> {    //variable para depositar dinero
                    System.out.println("DEPOSITAR DINERO");
                    System.out.println("EL MÁXIMO A DEPOSITAR ES DE 500000 PESOS");
                    System.out.println("SELECCIONA EL NUMERO DE CUENTA A LA QUE QUIERES DEPOSITAR DINERO");

                    int numeroCuenta = teclado.nextInt();

                    boolean cuentaEncontrada = false;
                    for (CuentaBancaria cuenta : lstBanco) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {     //buscar la cuenta en la que se quiere depositar dinero
                            cuentaEncontrada = true;
                            System.out.println("CUENTA ENCONTRADA: " + cuenta);
                            System.out.println("INGRESE LA CANTIDAD A DEPOSITAR:");
                            double deposito = teclado.nextDouble();
                            if (deposito < 500000 & deposito > 0) {     //condicional para máximo de deposito y evitar depositar negativos
                                cuenta.setSaldo(cuenta.getSaldo() + deposito);
                                System.out.println("DEPÓSITO REALIZADO");
                                break;
                            }
                            else {
                                System.out.println("EL DEPOSITO EXCEDE EL MAXIMO PERMITIDO");
                                System.out.println("NO SE HA REALIZADO EL DEPOSITO");
                            }
                        }
                    }
                    if (!cuentaEncontrada) {
                        System.out.println("CUENTA NO ENCONTRADA.");  //en caso de no existir la cuenta
                    }
                }
                case 5 -> {
                    System.out.println("RETIRAR DINERO");
                    System.out.println("SELECCIONA EL NUMERO DE CUENTA A LA QUE QUIERES RETIRAR DINERO");

                    int numeroCuenta = teclado.nextInt();

                    boolean cuentaEncontrada = false;
                    for (CuentaBancaria cuenta : lstBanco) {
                        if (cuenta.getNumeroCuenta() == numeroCuenta) {   //buscar la cuenta en la que se quiere retirar el dinero
                            cuentaEncontrada = true;
                            System.out.println("CUENTA ENCONTRADA: " + cuenta);
                            System.out.println("INGRESE LA CANTIDAD A RETIRAR:");
                            double retiro = teclado.nextDouble();
                            if (retiro < cuenta.getSaldo() & retiro > 0) {   //condicion para retirar dinero, evitar retirar negativos o retirar mas del dinero existente en la cuenta
                                cuenta.setSaldo(cuenta.getSaldo() - retiro);
                                System.out.println("RETIRO REALIZADO");
                                break;
                            }
                            else {
                                System.out.println("EL RETIRO NO PUEDE SER REALIZADO");
                            }
                        }
                    }
                    if (!cuentaEncontrada) {
                        System.out.println("CUENTA NO ENCONTRADA.");
                    }
                }
                case 6 -> {
                    System.out.println("SALIENDO...");
                    estado = false;   //terminar el programa
                }

            }
        } while (estado);  //continuar el programa mientras no lo terminen
    }
}



















       /* do {
            System.out.println("""
                    1. DEPOSITAR DINERO
                    2. RETIRAR DINERO
                    3. MOSTRAR DATOS DE LA CUENTA
                    4. MOSTRAR CLIENTES DE LA LISTA
                    5. SALIR""");

            op = teclado.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.println("DEPOSITAR");
                    do {

                        System.out.println("DINERO A DEPOSITAR");
                        monto = teclado.nextDouble();
                    }while(monto <0);
                    cl1.depositarDinero(monto);
                }
                case 2 -> {
                    System.out.println("RETIRAR");
                    do {
                        System.out.println("DINERO A RETIRAR");
                        monto = teclado.nextDouble();
                    }while(monto>0);
                    cl1.retirarDinero(monto);

                }
                case 3 -> {
                    System.out.println("MOSTRAR DATOS DE LA CUENTA");
                    cl1.mostrarInformacion();
                }
                case 4->{
                    System.out.println("MOSTRAR DATOS DE LA CUENTA DESDE LA LISTA");
                    System.out.println(lstBanco.toString());

                }
                case 5-> {
                    System.out.println("SALIENDO...");
                    estado = false;
                }
                default -> {
                    System.out.println("NO EXISTE LA OPCION");
                }
            }
        } while (estado);*/

