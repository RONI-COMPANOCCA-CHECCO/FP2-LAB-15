public class DepositoEstructurado extends Deposito{
    //ATRIBUTOS
    private double tipoInteresVariable;
    private double capitalVariable;
    //CONSTRUCTORES
    public DepositoEstructurado(){

    }
    public DepositoEstructurado(double tipoInteresVariable, double capitalVariable, Persona titular, double capital, int plazoDias, double tipoInteres){
        super(titular, capital, plazoDias, tipoInteres);
        this.tipoInteresVariable = tipoInteresVariable;
        this.capitalVariable = capitalVariable;
    }
    //METODOS GETTER Y SETTER
    public double getTipoInteresVariable(){
        return tipoInteresVariable;
    }
    public void setTipoInteresVariable(double tipoInteresVariable){
        this.tipoInteresVariable = tipoInteresVariable;
    }
    public double getCapitalVariable(){
        return capitalVariable;
    }
    public void setCapitalVariable(double capitalVariable){
        this.capitalVariable = capitalVariable;
    }
    //METODOS PUBLICOS
    public double getInteresesVariables(){
        return (getPlazoDias()*tipoInteresVariable*capitalVariable)/365;
    }
    public String toString(){
        StringBuilder sbCadena = new StringBuilder();
        sbCadena.append("\n Tipo Interes Variable: "+tipoInteresVariable);
        sbCadena.append("\n Capital Variable: "+ capitalVariable);
        sbCadena.append("Interes Variable: "+getInteresesVariables());
        return sbCadena.toString();
    }
}
