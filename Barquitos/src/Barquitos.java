import java.util.Arrays;
import java.util.Random;

public class Barquitos implements IBarquitos {
    private int[] numBarcosLong;
    private int sizeTablero;
    private Tablero tablero;

    public Barquitos(int[] numBarcosLong, int sizeTablero) {
        this.numBarcosLong = numBarcosLong;
        this.sizeTablero = sizeTablero;
        this.tablero = new Tablero(this.sizeTablero);
    }


    

    public Tablero getTablero(){
        return this.tablero;
    }

    public int getSizeMaxBarco() {
        return this.numBarcosLong.length;
    }

    public int getSizeTablero() {
        return this.sizeTablero;
    }

    public void colocarBarcos() {
        Random r = new Random();
        boolean vh = true;
        int posicion_x = 0;
        int posicion_y = 0;
        int size = this.sizeTablero;
        int cantidad = 0;
        boolean espacio = false;
        for (int i = 0; i < this.numBarcosLong.length; i++) {
            cantidad = this.numBarcosLong[i];
            for (int j = 0; j < cantidad; j++) {
                
                while (!espacio) {
                    vh = r.nextBoolean();
                    posicion_x = r.nextInt(size);
                    posicion_y = r.nextInt(size);
                    if(posicion_x+i+1<this.sizeTablero && posicion_x+i+1>=0)
                        if(posicion_y+i+1<this.sizeTablero && posicion_y+i+1>=0)
                            for (int k = 0; k < i + 1; k++) {
                                if (this.tablero.getPosicion(vh ? posicion_x + k : posicion_x,
                                        vh ? posicion_y : posicion_y + k) == 0) {
                                    espacio = true;
                                } else {
                                    espacio = false;
                                }
                            }
                }

                if (espacio) {
                    for (int y = 0; y < i + 1; y++) {
                        if (vh) {
                            this.tablero.setPosicion(posicion_x + y, posicion_y, 1);
                        } else {
                            this.tablero.setPosicion(posicion_x, posicion_y + y, 1);
                        }
                    }
                    espacio = false;
                }
            }

        }
    }

    public void disparo(int x, int y) {
        int value = this.tablero.getPosicion(x, y);
        switch (value) {
            case 0:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                this.tablero.setPosicion(x, y, value + 1);
        }
    }

    public void mostrarFinPartida() {
        System.out.println(this.tablero);
    }

    public boolean finPartida() {
        for (int i = 0; i < this.sizeTablero; i++) {
            for (int j = 0; j < this.sizeTablero; j++) {
                int posicion = this.tablero.getPosicion(i, j);
                if (posicion != 0 && posicion != 3 && posicion != 4) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(java.lang.String[] a) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Barquitos [\nnumBarcosLong=" + Arrays.toString(numBarcosLong) + ", \ntablero=\n" + tablero + "]";
    }

}