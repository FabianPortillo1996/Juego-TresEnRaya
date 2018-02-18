/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import controller.Juego;
import model.Jugador;


/*
 * @author Fabian
 */
public class FXMLviewController implements Initializable {

    private Juego juego;
    static Jugador jugador1;
    static Jugador jugador2;

    /**
     * Identifica si un Pane se encuentra vacio y pone la marca "X" o "O"
     *
     * @param e
     */
    @FXML
    protected void identificarPane(MouseEvent e) {
        Pane pane = (Pane) e.getSource();
        boolean vacio;

        vacio = pane.getChildren().isEmpty();
        String espaciojugado = pane.getId();
        espaciojugado = espaciojugado.substring(4);
        String marca = juego.setMarca(juego.getNoJugador(), vacio, espaciojugado);
        if (marca.equals("X") || marca.equals("O")) {
            Text textX = new Text(marca);
            setEstilosText(textX, pane);
            pane.getChildren().add(textX);
        } else {
            System.out.println(marca);
        }
    }

    private void setEstilosText(Text textX, Pane pane) {
        textX.setFont(Font.font("System", 96));
        textX.setFill(Paint.valueOf("#bdf271"));
        textX.setLayoutY(pane.getHeight() / 2 + 30);
        textX.setLayoutX(pane.getWidth() / 2 - 30);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        juego = new Juego();
        jugador1 = new Jugador("Fabian");
        jugador2 = new Jugador("Fabian 2");
    }
}
