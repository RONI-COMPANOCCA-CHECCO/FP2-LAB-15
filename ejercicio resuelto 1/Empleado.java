public class Empleado{
    //ATRIBUTOS
    private String nombre, categoria;
    private int numeroHijos;
    private double sueldoBasico, bonificacionCategoria, bonificacionEscolaridad, sueldoNeto;
    //ATRIBUTOS STATIC
    public static double sumaSueldosNombrados = 0.00;
    public static double sumaSueldosContratados = 0.00;
    public static double sumaSueldosPorHoras = 0.00;

    public static int contaMenos3Hijos = 0;
    public static int contaMenos6Hijos = 0;
    public static int contaMas6Hijos = 0;
    //CONSTRUCTORES
    public Empleado(){
        this.nombre = "";
        this.categoria = "";
        this.numeroHijos = 0;
        this.sueldoBasico = 0;
        this.bonificacionCategoria = 0.00;
        this.bonificacionEscolaridad = 0.00;
        this.sueldoNeto = 0.00;
    }
    public Empleado(String nombre, String categoria, int numeroHijos, double sueldoBasico){
        this.nombre = nombre;
        this.categoria = categoria;
        this.numeroHijos = numeroHijos;
        this.sueldoBasico = sueldoBasico;
        this.bonificacionCategoria = 0.00;
        this.bonificacionEscolaridad = 0.00;
        this.sueldoNeto = 0.00;
    }
    //METODO GETTER Y SETTER
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public int getNumeroHijos(){
        return numeroHijos;
    }
    public void setNumeroHijos(int numeroHijos){
        this.numeroHijos = numeroHijos;
    }
    public double getSueldoBasico(){
        return sueldoBasico;
    }
    public void setSueldoBasico(double sueldoBasico){
        this.sueldoBasico = sueldoBasico;
    }
    public double getBonificacionCategoria(){
        return bonificacionCategoria;
    }
    public double getBonificacionEscolaridad(){
        return bonificacionEscolaridad;
    }
    public double getSueldoNeto(){
        return sueldoNeto;
    }
    //METODOS PRIVADOS0
    private void CalcularBonificacion(){
        switch (this.categoria.toLowerCase().trim()){
            case "nombrado":
                this.bonificacionCategoria = this.sueldoBasico * 0.12;
                break;
            case "contratado":
                this.bonificacionCategoria = this.sueldoBasico * 0.10;
                break;
            case "por horas":
                this.bonificacionCategoria = this.sueldoBasico * 0.08;
                break;        
            default:
                this.bonificacionCategoria = this.sueldoBasico * 0.06;
        }
    }
    private void calcularEscolaridad(){
        if(numeroHijos>=1 && numeroHijos<3){
            bonificacionEscolaridad = numeroHijos*20;
            contaMenos3Hijos++;
        }else if (numeroHijos <= 6){
            bonificacionEscolaridad = numeroHijos*30;
            contaMenos6Hijos++;
        }else if(numeroHijos > 6){
            bonificacionEscolaridad = numeroHijos*40;
            contaMas6Hijos++;
        }
    }
    // METODOS UBLICOS
    public void calcularSueldoNeto(){
        this.CalcularBonificacion();
        this.calcularEscolaridad();
        this.sueldoNeto = sueldoBasico + bonificacionCategoria + bonificacionEscolaridad;
    }
}