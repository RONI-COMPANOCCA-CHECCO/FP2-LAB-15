import java.util.ArrayList;

public class Ejercito {
    private String reino;
    private ArrayList<Soldado> misSoldados;

    // Constructor
    public Ejercito(String reino) {
        this.reino = reino;
        this.misSoldados = new ArrayList<>();
    }

    // Getters y Setters
    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    // Método para agregar un soldado al ejército
    public void agregarSoldado(Soldado soldado) {
        if (misSoldados.size() < 10) {
            misSoldados.add(soldado);
        } else {
            System.out.println("El ejército ya tiene el máximo de soldados permitidos (10).");
        }
    }

    // Método para eliminar un soldado por nombre
    public void eliminarSoldado(String nombreSoldado) {
        for (Soldado soldado : misSoldados) {
            if (soldado.getNombre().equals(nombreSoldado)) {
                misSoldados.remove(soldado);
                System.out.println("Soldado eliminado exitosamente: " + nombreSoldado);
                return;
            }
        }
        System.out.println("Soldado no encontrado: " + nombreSoldado);
    }

    // Método para modificar un atributo de un soldado por nombre
    public void modificarSoldado(String nombreSoldado, String atributo, Object valor) {
        for (Soldado soldado : misSoldados) {
            if (soldado.getNombre().equals(nombreSoldado)) {
                switch (atributo) {
                    case "nombre":
                        soldado.setNombre((String) valor);
                        break;
                    // Agregar más casos según los atributos que se puedan modificar
                    default:
                        System.out.println("Atributo no válido: " + atributo);
                        return;
                }
                System.out.println("Soldado modificado exitosamente: " + nombreSoldado);
                return;
            }
        }
        System.out.println("Soldado no encontrado: " + nombreSoldado);
    }

    // Método para consultar el soldado con mayor nivel de ataque
    public Soldado consultarSoldadoMasPoderoso() {
        Soldado masPoderoso = null;
        int maxNivelAtaque = Integer.MIN_VALUE;

        for (Soldado soldado : misSoldados) {
            if (soldado.getNivelAtaque() > maxNivelAtaque) {
                maxNivelAtaque = soldado.getNivelAtaque();
                masPoderoso = soldado;
            }
        }

        return masPoderoso;
    }

    // Método para ver el ranking de poder considerando el nivel de vida (descendente)
    public ArrayList<Soldado> consultarRankingPoder() {
        ArrayList<Soldado> ranking = new ArrayList<>(misSoldados);
        ranking.sort((s1, s2) -> Integer.compare(s2.getVidaActual(), s1.getVidaActual()));
        return ranking;
    }

    // Método para ver todos los datos del ejército y de los soldados que lo conforman
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Ejército de " + reino + ":\n");
        for (Soldado soldado : misSoldados) {
            result.append("\t").append(soldado.toString()).append("\n");
        }
        return result.toString();
    }
}