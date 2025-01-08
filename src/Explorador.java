public class Explorador {
    private String nombre;
    private Posicion posicion;

    public Explorador(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        int fila = (int) (Math.random() * filas);
        int columna = (int) (Math.random() * columnas);
        this.posicion = new Posicion(fila, columna);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void moverse(String direccion, Mapa mapa) {
        int nuevaFila = posicion.getCoordenadaFila();
        int nuevaColumna = posicion.getCoordenadaCol();

        switch (direccion.toUpperCase()) {
            case "W" -> nuevaFila--;
            case "S" -> nuevaFila++;
            case "A" -> nuevaColumna--;
            case "D" -> nuevaColumna++;
            default -> {
                System.out.println("Dirección no válida. Usa W, A, S, D.");
                return;
            }
        }

        if (!mapa.posicionValida(nuevaFila, nuevaColumna)) {
            System.out.println("No puedes moverte fuera del mapa.");
            return;
        }

        mapa.limpiarPosicion(posicion);
        posicion.setCoordenadaFila(nuevaFila);
        posicion.setCoordenadaCol(nuevaColumna);
        mapa.colocarExplorador(posicion, 'J');
    }

    public boolean haEncontradoTesoro(Mapa mapa) {
        return mapa.obtenerSimbolo(posicion) == 'P';
    }

    public boolean haCaidoEnTrampa(Mapa mapa) {
        return mapa.obtenerSimbolo(posicion) == 'T';
    }

    public boolean estaConEnemigos(Enemigo[] enemigos) {
        for (Enemigo enemigo : enemigos) {
            if (posicion.equals(enemigo.getPosicion())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Explorador: " + nombre + ", Posición actual: " + posicion;
    }
}