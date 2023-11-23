import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner consola = new Scanner(System.in);
        String resp = "";
        do{
            //INGRESAMOS LOS DATOS DEL EMPLEADO
            System.out.println("ingrese NOMBRES del Empleado");
            String nombres = consola.next();
            System.out.println("Ingrese CATEGORIA del Empleado");
            System.out.println("Nombrado  |  Contratado  | Por Horas:  ");
            String categoria = consola.next();
            System.out.println("Ingrese SUELDO BASICO del Empleado: ");
            double sueldo =consola.nextDouble();
            System.out.println("Ingrese NUMERO DE HIJOS del Empleado: ");
            int nroHijos = consola.nextInt();
            // CREAMOS INSTANCIA DE LA CLASE EMPLEADO
            Empleado objEmpleado = new Empleado(nombres, categoria, nroHijos, sueldo);
            // LLAMAMOS AL SEGUNDO CONSTRUCTOR
            objEmpleado.calcularSueldoNeto();
            // CALCULAMOS SUELDOS ACUMULADOS POR CADA TIPO DE EMPLEADO
            if(objEmpleado.getCategoria().equals("nombrado"))
            {
                Empleado.sumaSueldosNombrados += objEmpleado.getSueldoNeto();
            }else
                if(objEmpleado.getCategoria().equals("contratado")){
                Empleado.sumaSueldosContratados += objEmpleado.getSueldoNeto();
                }  
                else 
                    if(objEmpleado.getCategoria().equals("por horas")){
                    Empleado.sumaSueldosPorHoras += objEmpleado.getSueldoNeto();
                    }
            //MOSTRAMOS RESULTADOS POR EMPLEADO
            System.out.println("Bonificacion Categoria: "+objEmpleado.getBonificacionCategoria());
            System.out.println("Bonificacion Escolaridad: "+objEmpleado.getBonificacionEscolaridad());
            System.out.println("Sueldo Neto: "+objEmpleado.getSueldoNeto());
            System.out.println("¿Desea seguir? (si/no)");
            resp = consola.next();
        }while(resp.equalsIgnoreCase("si")||resp.equalsIgnoreCase("s"));
        // MOSTRAMOS RESULTADOS ACUMULADOS FINALES
        System.out.println("\n--------------\nRESULTADOS FINALES\n------------------");
        System.out.println("Total Sueldos Nombrados: "+Empleado.sumaSueldosNombrados);
        System.out.println("Total Sueldos Contratados: "+Empleado.sumaSueldosContratados);
        System.out.println("Total Sueldos Por Horas: "+Empleado.sumaSueldosPorHoras);
        System.out.println("Numero Empleados con MENOS de 3 Hijos: "+Empleado.contaMenos3Hijos);
        System.out.println("Numero Empleados con MENOS de 6 Hijos: "+Empleado.contaMas6Hijos);
        System.out.println("Numero Empleados con MAS de 6 Hijos: "+Empleado.contaMas6Hijos);
    }
}
