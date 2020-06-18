import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

import java.util.*;

public class Ventana implements ActionListener {
    private int size;
    private JFrame frame;
    private GridLayout layout;
    JButton aux;
    private ArrayList<JButton> etiquetas;
    Barquitos juego;

    public Ventana(int size) {
        this.size = size;
        int[] barcos = {3,2,1};
        this.juego = new Barquitos(barcos,this.size);
        this.juego.colocarBarcos();
        System.out.println(this.juego);
        this.frame = new JFrame("Barquitos");
        this.layout = new GridLayout(this.size,this.size);
        this.frame.setLayout(layout);
        this.etiquetas = new ArrayList<>();
        for (int i = 0; i < this.size * this.size; i++) {
                this.aux = new JButton("X");
                this.aux.addActionListener(this);
                this.aux.setActionCommand(""+i+"");
                this.etiquetas.add(aux); 
        }
        for (JButton aux : etiquetas) {
            this.frame.add(aux);
        }
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        int cast = Integer.parseInt(command);
        System.out.println("cast = " + cast);
        int index = 0;
        for (int i = 0; i < this.juego.getSizeTablero(); i++) {
            for (int j = 0; j < this.juego.getSizeTablero(); j++) {
                if(index == cast){
                    actualizarButton(i,j,cast);
                }
                index++;
            }
        }
        
    }
    
    public void actualizarButton(int x, int y,int index){
        Tablero t = this.juego.getTablero();
        int opc = t.getPosicion(x, y);
        switch(opc){
            case 0:
                this.etiquetas.get(index).setText("0");
                t.setPosicion(x, y, 4);
                break;
            case 1:
                this.etiquetas.get(index).setText("2");
                t.setPosicion(x, y, 2);
                break;
            case 2:
                this.etiquetas.get(index).setText("2");
                break;
        }
        System.out.println(t);
    }

    public void insertarVista​(java.awt.Component comp){
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    
}