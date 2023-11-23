// RONI COMPANOCCA CHECCO
// CUI: 20210558
// LABORATORIO 15
// FUNDAMENTOS DE PROGRAMACION 
import java.util.*;

public class Main{

	public static void main(String[] args) {

		//DECLARACION DE VARIABLES Y ARREGLOS NECESARIOS
		// Crea el tablero y los ejércitos
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<>();
        ArrayList<Soldado> ejercito1 = new ArrayList<>();
        ArrayList<Soldado> ejercito2 = new ArrayList<>();

        inicializarTablero(tablero);
        inicializarEjercitos(ejercito1, ejercito2);

        // Muestra el tablero inicial
        imprimirTablero(tablero);

        // Ciclo del juego
        boolean juegoEnCurso = true;
        int jugadorActual = 1;

        while (juegoEnCurso) {
            // Turno del jugador
            ArrayList<Soldado> ejercitoActual = (jugadorActual == 1) ? ejercito1 : ejercito2;
            ArrayList<Soldado> ejercitoOponente = (jugadorActual == 1) ? ejercito2 : ejercito1;

            System.out.println("\nJugador " + jugadorActual + ", es tu turno:");

            // Solicita la coordenada del soldado a mover y la dirección
            int fila, columna, nuevaFila, nuevaColumna;
            Soldado soldado;

            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ingrese la fila del soldado a mover (1-10): ");
                fila = scanner.nextInt() - 1;
                System.out.print("Ingrese la columna del soldado a mover (A-J): ");
                scanner.nextLine(); // Consumir el salto de línea anterior
                String columnaStr = scanner.nextLine();
                nuevaFila = fila;
                nuevaColumna = columnaStr.charAt(0) - 'A';
                soldado = tablero.get(fila).get(nuevaColumna);

                if (fila < 0 || fila >= 10 || nuevaColumna < 0 || nuevaColumna >= 10) {
                    System.out.println("Coordenadas fuera del rango. Intente de nuevo.");
                } else if (soldado == null || soldado.getVive() == false) {
                    System.out.println("No hay un soldado en esa posición o está muerto. Intente de nuevo.");
                } else if (!esMovimientoValido(tablero, fila, nuevaColumna, nuevaFila, nuevaColumna)) {
                    System.out.println("Movimiento no válido. Intente de nuevo.");
                }
            } while (fila < 0 || fila >= 10 || nuevaColumna < 0 || nuevaColumna >= 10 || soldado == null || soldado.getVive() == false || !esMovimientoValido(tablero, fila, nuevaColumna, nuevaFila, nuevaColumna));

            // Realizar el movimiento
            Soldado soldadoOponente = tablero.get(nuevaFila).get(nuevaColumna);
            if (soldadoOponente != null && soldadoOponente.getVive()) {
                // Batalla
                System.out.println("¡Batalla!");
                double probabilidadGanarJugador = calcularProbabilidad(soldado.getPuntos(), soldadoOponente.getPuntos());

                Random random = new Random();
                double resultado = random.nextDouble();

                if (resultado <= probabilidadGanarJugador) {
                    System.out.println("¡Gana el Jugador " + jugadorActual + "!");
                    aumentarVida(soldado);
                    eliminarSoldado(tablero, ejercitoOponente, nuevaFila, nuevaColumna);
                } else {
                    System.out.println("¡Gana el Jugador " + (jugadorActual == 1 ? 2 : 1) + "!");
                    aumentarVida(soldadoOponente);
                    eliminarSoldado(tablero, ejercitoActual, fila, nuevaColumna);
                }
            } else {
                // Movimiento normal
                tablero.get(nuevaFila).set(nuevaColumna, soldado);
                tablero.get(fila).set(nuevaColumna, null);
                soldado.setColumna(nuevaColumna);
                soldado.setFila(nuevaFila);
            }

            // Mostrar el tablero actualizado
            imprimirTablero(tablero);

            // Verificar si hay un ganador
            if (ejercito1.isEmpty()) {
                System.out.println("¡Jugador 2 gana!");
                juegoEnCurso = false;
            } else if (ejercito2.isEmpty()) {
                System.out.println("¡Jugador 1 gana!");
                juegoEnCurso = false;
            }

            // Cambiar al siguiente jugador
            jugadorActual = (jugadorActual == 1) ? 2 : 1;
        }
	}

	// METODO PARA CREAR NUMEROS ALEATORIOS EN UN RANGO
	public static int aleatorio(int min, int max) {
		return(int)(Math.random()*(max-min+1)+min);
	}

	// METODO PARA INICIAR UN ARRAYLIST
	public static void inicializarArreglo (ArrayList<Soldado> soldadito, int num) {
		for (int i=0; i<num; i++) {
			soldadito.add(new Soldado());
		}
	}

	// METODO PARA GENERAR DATOS DEL OBJETO SOLDADO
	public static Soldado generarDatos() {
		Soldado soldadito = new Soldado();
		soldadito.setPuntos(aleatorio(1,5));
		soldadito.setColumna(aleatorio(1,10));
		soldadito.setFila(aleatorio(1,10));
		return soldadito;
	}

	// METODOS PARA GENERAR LOS EJERCITOS DE MANERA ALEATORIA
	public static void generarEjercitos(ArrayList<Soldado>B1, ArrayList<Soldado>B2) {
		ArrayList<Soldado>Soldados = new ArrayList();
		Soldados.add(generarDatos());
		for (int i=1; i<(B1.size()+B2.size()); i++) {
			Soldados.add(generarDatos());
			for (int j=0; j<i; j++) {
				if(Soldados.get(i).getFila()==Soldados.get(j).getFila()) {
					if(Soldados.get(i).getColumna()==Soldados.get(j).getColumna()){
						Soldados.remove(i);
						i--;
					}
				}
			}
		}
		for (int i=0; i<B1.size(); i++) {
			B1.add(i, Soldados.get(i));
			B1.get(i).setNombre("Soldado"+i+"x1");
			B1.get(i).setColumn(B1.get(i).getPuntos()+"[E1]");
			B1.remove(i+1);
		}
		for (int i=0; i<B2.size(); i++) {
			B2.add(i, Soldados.get(i+B1.size()));
			B2.get(i).setNombre("Soldado"+i+"x2");
			B2.remove(i+1);
			B2.get(i).setColumn(B2.get(i).getPuntos()+"[E2]");
		}
	}

	// METODO PARA AÑADIR LOS EJERCITOS AL TABLERO
	public static void añadirTablero(ArrayList<Soldado>soldadito, ArrayList<ArrayList<Soldado>>table) {
		for (int i=0; i<soldadito.size(); i++) {
			table.get(soldadito.get(i).getColumna()-1).add(soldadito.get(i).getFila()-1,soldadito.get(i));
			table.get(soldadito.get(i).getColumna()-1).remove(soldadito.get(i).getFila());
		}
	}

	// METODO PARA IMPRIMIR EL TABLERO EN LA CUAL SE DESARROLLA EL JUEGO
	public static void imprimirTablero(ArrayList<ArrayList<Soldado>> table) {
		System.out.println("\tA\tB\tC\tD\tF\tG\tH\tI\tJ");
		for(int i=0; i<table.size(); i++) {
			System.out.print(i+1);
			for(int j=0; j<table.get(i).size();j++) {
				System.out.print("\t"+table.get(i).get(j).getColumn());
			}
			System.out.println("\n");
		}
	}
	
	//METODO PARA IMPRIMIR LOS SOLDADOS DE MAYOR VIDA
	public static void SoldadoConMayorVida (ArrayList<Soldado>soldadito) {
		Soldado mayor = new Soldado();
		mayor.setPuntos(0);
		for(int i=0; i<soldadito.size();i++) {
			if (mayor.getPuntos()<soldadito.get(i).getPuntos()) {
				mayor = soldadito.get(i);
			}
		}
		imprimir(mayor);
	}
	
	// METODO PARA IMPRIMIR EL NOMBRE, LA POSICION Y NIVEL DE VIDA DEL SOLDADO
	public static void imprimir(Soldado soldadito) {
		System.out.println("Nombre: "+soldadito.getNombre()+"\nPosicion: "+soldadito.getColumna()+"X"+soldadito.getFila()+"\tVida: "+soldadito.getPuntos());
	}
	
	// METODO QUE NOS AYUDA A ORDENAR LOS SOLDADOS DE ACUERDO A SU NIVEL DE VIDA, USUANDO UN ALGORITMO DE ORDENAMIENTO DE BURBUJA
	public static void ordenarPorVidaMetodoA(ArrayList<Soldado>soldadito) {
		Soldado aux = new Soldado();
		for(int i=0; i<soldadito.size()-1; i++) {
			for(int j=0; j<soldadito.size()-i-1; j++) {
				if(soldadito.get(j).getPuntos()<soldadito.get(j+1).getPuntos()) {
					aux = soldadito.get(j);
					soldadito.set(j,soldadito.get(j+1));
					soldadito.set(j+1,aux);
				}
			}
		}
	}

    // METODO QUE NOS AYUDA A ORDENAR LOS SOLDADOS DE ACUERDO A SU NIVEL DE VIDA, EN ESTA OCACION DIFERENTE A LA ANTERIOR QUE ERA ALGORITMO DE BURBUJA
    public static void ordenarPorVidaMetodoB(ArrayList<Soldado> soldadito) {
        Collections.sort(soldadito, new Comparator<Soldado>() {
            public int compare(Soldado s1, Soldado s2) {
                // Orden descendente por puntos de vida
                return Integer.compare(s2.getPuntos(), s1.getPuntos());
            }
        });
    }
}
