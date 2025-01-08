public class Posicion {
    private int coordenadaFila;
    private int coordenadaCol;

    public Posicion(int fila, int columna) {
        this.coordenadaFila = fila;
        this.coordenadaCol = columna;
    }

    public int getCoordenadaFila() {
        return coordenadaFila;
    }

    public void setCoordenadaFila(int coordenadaFila) {
        this.coordenadaFila = coordenadaFila;
    }

    public int getCoordenadaCol() {
        return coordenadaCol;
    }

    public void setCoordenadaCol(int coordenadaCol) {
        this.coordenadaCol = coordenadaCol;
    }


    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        Posicion posicion = (Posicion) obj;
        return coordenadaFila == posicion.coordenadaFila && coordenadaCol == posicion.coordenadaCol;
    }

    @Override
    public String toString() {
        return "[" + coordenadaFila + ", " + coordenadaCol + "]";
    }
}
