public class Enemigo {
    private String nombre;
    private Posicion posicion;

    public Enemigo(String nombre, int filas, int columnas) {
        this.nombre = nombre;

        int fila = (int) (Math.random() * filas);
        int columna = (int) (Math.random() * columnas);
        this.posicion = new Posicion(fila, columna);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void moverse(Mapa mapa) {
        int nuevaFila = posicion.getCoordenadaFila();
        int nuevaColumna = posicion.getCoordenadaCol();

        int direccion = (int) (Math.random() * 4);

        switch (direccion) {
            case 0 -> nuevaFila--;     // Arriba
            case 1 -> nuevaFila++;     // Abajo
            case 2 -> nuevaColumna--;  // Izquierda
            case 3 -> nuevaColumna++;  // Derecha
        }


        if (nuevaFila < 0 || nuevaFila >= mapa.getFilas() || nuevaColumna < 0 || nuevaColumna >= mapa.getColumnas()) {
            return;
        }

        if (mapa.esPosicionOcupada(new Posicion(nuevaFila, nuevaColumna))) {
            return;
        }

        mapa.limpiarPosicion(posicion);

        posicion.setCoordenadaFila(nuevaFila);
        posicion.setCoordenadaCol(nuevaColumna);

        mapa.colocarEnemigo(posicion, 'E');
    }

    @Override
    public String toString() {
        return "Enemigo: " + nombre + ", Posición actual: [" + posicion.getCoordenadaFila() + ", " + posicion.getCoordenadaCol() + "]";
    }
}
