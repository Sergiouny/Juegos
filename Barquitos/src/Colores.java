

import java.awt.Color;

public enum Colores {
    AGUA(0, java.awt.Color.BLUE),
    CUBIERTO(1, java.awt.Color.BLACK),
    TOCADO(2, java.awt.Color.ORANGE),
    HUNDIDO(3, java.awt.Color.RED),
    BORDE(4, java.awt.Color.WHITE);

    private int valor;
    private Color color;

    private Colores(final int valor, final Color color) {
        this.valor = valor;
        this.color = color;
    }

    public java.awt.Color getColor​() {
        return this.color;
    }

    public int getValor​() {
        return this.valor;
    }

    public static java.awt.Color getColor​(final int valor) {
        final Colores[] aux = values();
        for (final Colores color : aux) {
            if (color.getValor​() == valor) {
                return color.getColor​();
            }
        }
        return null;
    }

    public static Colores[] values​() {
        final Colores[] aux = new Colores[5];
        int index = 0;
        for (final Colores c : Colores.values()) {
            aux[index] = c;
            index++;
        }
        return aux;
    }

    public static Colores valueOf​(java.lang.String name) {
        final Colores[] aux = values();
        for (final Colores color : aux) {
            if (color.equals(name)) {
                return color;
            }
        }
        return null;
    }

    
}

