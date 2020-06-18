

public class Tablero implements ITablero {
    private int size;
    private int[][] tablero;

    public Tablero(int size) {
        this.size = size;
        this.tablero = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.tablero[i][j] = 0;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int[][] getTablero() {
        return this.tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int getPosicion(int x, int y) {
        return this.tablero[x][y];
    }

    public void setPosicion(int x, int y, int value) {
        this.tablero[x][y] = value;
    }

    public void borra() {
        Tablero aux = new Tablero(this.size);
        this.tablero = aux.getTablero();
    }

    public int ocupacion() {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.getPosicion(i, j) == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    @Override
    public String toString() {
        String tableroS = "";
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                tableroS+=this.getPosicion(i, j) + " ";
            }
            tableroS+="\n";
        }
        return "Tablero [size=" + size + ",\ntablero=\n" + tableroS + "]";
    }

// TODO : ver esta parte de los Listeners

/**
    public void addPropertyChangeListener​(java.beans.PropertyChangeListener pcl){

    }

    public void removePropertyChangeListener​(java.beans.PropertyChangeListener pcl){

    }
 */
    
}