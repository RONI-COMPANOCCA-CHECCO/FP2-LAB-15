public class Persona {
    //ATRIBUTOS
    private String dni;
    private String nombre;
    private String direccion;
    //CONSTRUCTORES
    public Persona(){
        this.dni = "";
        this.nombre = "";
        this.direccion = "";
    }
    public Persona(String dni, String nombre, String direccion){
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    //METODOS GETTER Y SETTER
    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}
