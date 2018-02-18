package controller;

import static controller.FXMLviewController.jugador1;
import static controller.FXMLviewController.jugador2;

/**
 *
 * @author Fabian
 */
public class Juego {

    int nojugador;
    int[][] opcionesganar;
    int totalClick;

    public Juego() {
        opcionesganar = new int[][]{
            {0, 1, 2},
            {10, 11, 12},
            {20, 21, 22},
            {0, 10, 20},
            {1, 11, 21},
            {2, 12, 22},
            {0, 11, 22},
            {20, 11, 0}};
        totalClick = 0;
    }

    public String setMarca(int numberjugador, boolean vacio, String espaciojugado) {
        if (vacio && poderJugar()) {
            if (numberjugador == 1) {
                nojugador = 0;
                ++totalClick;
                jugador1.setEspacioJugado("," + espaciojugado);
                System.out.println("Jugador 1 :" + jugador1.getEspacioJugados());
                return "X";
            } else {
                nojugador = 1;
                ++totalClick;
                jugador2.setEspacioJugado("," + espaciojugado);
                System.out.println("Jugador 2 :" + jugador2.getEspacioJugados());
                return "O";
            }

        } else {
            nojugador = numberjugador;
            return "";
        }
    }

    public int getNoJugador() {
        return nojugador;
    }

    public boolean poderJugar() {
        return true;
    }

    public boolean compruebaEmpate() {
        if (totalClick == 8) {
            return true;
        }
        return false;
    }
}
