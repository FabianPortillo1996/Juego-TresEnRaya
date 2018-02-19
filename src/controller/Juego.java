package controller;

import static controller.FXMLviewController.jugador1;
import static controller.FXMLviewController.jugador2;

/**
 *
 * @author Fabian
 */
public class Juego {

    private int nojugador;
    private int[][] opcionesganar;
    private int totalClick;

    public Juego() {
        opcionesganar = new int[][]{
            {0, 1, 2},
            {10, 11, 12},
            {20, 21, 22},
            {0, 10, 20},
            {1, 11, 21},
            {2, 12, 22},
            {0, 11, 22},
            {20, 11, 2}};
        totalClick = 0;
    }

    public boolean compruebaAciertos(int[] espacios_jugados) {

        int filas = opcionesganar.length;
        int columnas = opcionesganar[0].length;
        int longitud = espacios_jugados.length;
        int aciertos = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < longitud; k++) {
                    if (espacios_jugados[k] == opcionesganar[i][j]) {
                        aciertos++;
                        if (aciertos == 3) {
                            return true;
                        }
                    }
                }
            }
            aciertos = 0;
        }
        return false;
    }

    public String setMarca(int numberjugador, boolean vacio, String espaciojugado) {
        if (vacio) {
            if (numberjugador == 1) {
                nojugador = 0;
                totalClick++;
                jugador1.setEspacioJugado(espaciojugado + ",");
                return "X";
            } else {
                nojugador = 1;
                totalClick++;
                jugador2.setEspacioJugado(espaciojugado + ",");
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

    public String estadoJuego() {
        if (totalClick >= 4) {
            if (compruebaAciertos(parsearEspacios(jugador1.getEspacioJugados()))) {
                return "Ganador " + jugador1.getNombreJugador();
            }
            if (compruebaAciertos(parsearEspacios(jugador2.getEspacioJugados()))) {
                return "Ganador " + jugador2.getNombreJugador();
            }
        }
        if (totalClick == 9) {
            return "Empate";
        }
        return "Ninguno";
    }

    public int[] parsearEspacios(String espacios) {
        String[] espacios_array = espacios.split(",");
        int length = espacios_array.length;
        int[] espacios_int = new int[length];
        for (int i = 0; i < length; i++) {
            espacios_int[i] = Integer.parseInt(espacios_array[i]);
        }
        return espacios_int;
    }

}
