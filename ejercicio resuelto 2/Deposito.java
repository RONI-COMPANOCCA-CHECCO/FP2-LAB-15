public class Deposito {
    //ATRIBUTOS
    private Persona titular; // RELACION ASOCIACION
    private double capital;
    private int plazoDias;
    private double tipoInteres;
    //CONSTRUCTORES
    public Deposito(){
        this.titular = null;
        this.capital = 0.00;
        this.plazoDias = 0;
        this.tipoInteres = 0.00;
    }
    public Deposito(Persona titular, double capital, int plazoDias, double tipoInteres){
        this.titular = titular;
        this.capital = capital;
        this.plazoDias = plazoDias;
        this.tipoInteres = tipoInteres;
    }
    //METODOS GETTER Y SETTER
    public Persona getTitular(){
        return titular;
    }
    public void setTitular(Persona titular){
        this.titular = titular;
    }
    public double getCapital(){
        return capital;
    }
    public void setCapital(double capital){
        this.capital = capital;
    }
    public int getPlazoDias(){
        return plazoDias;
    }
    public void setPlazoDias(int plazoDias){
        this.plazoDias = plazoDias;
    }
    public double getTipoInteres(){
        return tipoInteres;
    }
    public void setTipoInteres(double tipoInteres){
        this.tipoInteres = tipoInteres;
    }
    //METODOS PUBLICOS
    public double getIntereses(){
        return(plazoDias*tipoInteres*capital/365);
    }
    public double liquidar(){
        return getCapital()+getIntereses();
    }
    public String toString(){
        StringBuilder sbCadena = new StringBuilder();
        sbCadena.append("\n Titular: "+titular.getDni()+titular.getNombre());
        sbCadena.append("\n Capital: "+capital);
        sbCadena.append("\n plazo Dias: "+plazoDias);
        sbCadena.append("\n Tipo Interes: "+tipoInteres);
        sbCadena.append("\n TOTAL: "+liquidar());
        return sbCadena.toString();
    }
}