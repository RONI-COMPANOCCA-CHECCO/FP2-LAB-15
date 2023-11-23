public class Soldado {
	private String nombre;
    private int fila;
    private int columna;
    private String column;
    private int nivelAtaque;
    private int nivelDefensa;
    private int puntos;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
	
	public Soldado() {
		nombre = "";
        fila = 0;
        columna = 0;
        column = "";
        nivelAtaque = 0;
        nivelDefensa = 0;
        puntos = 0;
        vidaActual = 0;
        velocidad = 0;
        actitud = "";
        vive = true;
	}

	// METODOS MUTADORES
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public void setColumn(String column) {
		this.column = column;
	}

	public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

	// METODOS ACCESORES
	public String getNombre() {
		return nombre;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	public String getColumn() {
		return column;
	}

	public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getActitud() {
        return actitud;
    }

    public boolean getVive() {
        return vive;
    }

	// Otros métodos

    public void serAtacado() {
    }

    // Método para atacar: avanza y aumenta la velocidad en 1
    public void atacar() {
        avanzar();
        this.velocidad++;
        this.actitud = "ofensiva";
    }

    // Método para avanzar: aumenta la velocidad en 1
    public void avanzar() {
        this.velocidad++;
    }

    // Método para defender: el soldado se detiene
    public void defender() {
        this.actitud = "defensiva";
        this.velocidad = 0;
    }

    // Método para huir: aumenta la velocidad en 2
    public void huir() {
        this.actitud = "fuga";
        this.velocidad += 2;
    }

    // Método para retroceder: disminuye la velocidad o se para
    public void retroceder() {
        if (this.velocidad > 0) {
            defender();
        } else {
            this.velocidad--; // Disminuye a valores negativos si la velocidad es 0
        }
    }

    // Método para ser atacado: disminuye el nivel de vida
    public void serAtacado(int danio) {
        this.vidaActual -= danio;
        if (this.vidaActual <= 0) {
            morir();
        }
    }

    // Método para morir: cambia el estado del soldado a "no vive"
    public void morir() {
        this.vive = false;
    }

    public void aumentarVida() {
        this.vidaActual++;
    }

}