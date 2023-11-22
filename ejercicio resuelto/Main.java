import java.util.Scanner;

public class Main {
    static Scanner consola = new Scanner(System.in);
    public Persona crearTitular(){
        Persona persona;
        System.out.println("Ingrese el nombre: ");
        String nombre = consola.next();
        System.out.println("Ingrese el DNI: ");
        String dni = consola.next();
        System.out.println("Ingrese la Direccion: ");
        String direccion = consola.next();
        persona = new Persona(dni, nombre, direccion);
        return persona;
    }
    public Deposito crearDeposito(int tipo){
        System.out.println("-----------------------\n NUEVO DEPOSITO\n--------------------------");
        System.out.println("DATOS DEL TITULAR\n ------------------");
        Persona persona = crearTitular();
        System.out.println("\nDATOS DEL DEPOSITO\n---------------------");
        System.out.println("Ingrese el Capital: ");
        double capital = consola.nextDouble();
        System.out.println("Ingrese el Plazo Dias: ");
        int plazo = consola.nextInt();
        System.out.println("Ingrese el Tipo de Interes: ");
        double tipoInteres = consola.nextDouble();
        if(tipo == 1){
            Deposito objDeposito = new Deposito(persona, capital, plazo, tipoInteres);
            return objDeposito;
        }
        else{
            System.out.println("Ingrese el Interes Variable: ");
            double interesVariable = consola.nextDouble();
            System.out.println("Ingrese el Capital Variable: ");
            double capitalVariable = consola.nextDouble();
            DepositoEstructurado objDepositoEstructurado = new DepositoEstructurado(interesVariable, capitalVariable, persona, capital, plazo, tipoInteres);
            return objDepositoEstructurado;
        }
    }
    public static void main(String[] args){
        Main objPrincipal = new Main();
        System.out.println("1. Crear Deposito");
        System.out.println("2. Crear Deposito Estructurado");
        int opcion = consola.nextInt();
        Deposito deposito = objPrincipal.crearDeposito(opcion);
        System.out.println(deposito.toString());
    }
}