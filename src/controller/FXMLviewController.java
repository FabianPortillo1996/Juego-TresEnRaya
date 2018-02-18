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
import javafx.scene.layout.AnchorPane;
import model.Jugador;


/*
 * @author Fabian
 */
public class FXMLviewController implements Initializable {

    @FXML
    private Pane pane00, pane01, pane02,
            pane10, pane11, pane12,
            pane20, pane21, pane22;
    @FXML
    private AnchorPane ventana;

    private Juego juego;
    static Jugador jugador1;
    static Jugador jugador2;

    @FXML
    protected void identificarPane(MouseEvent e) {
        Pane pane = (Pane) e.getSource();
        boolean vacio;
        if (pane.getChildren().isEmpty()) {
            vacio = true;
        } else {
            vacio = false;
        }
        String espaciojugado = pane.getId();
        espaciojugado = espaciojugado.substring(4);

        Text textX = new Text(juego.setMarca(juego.getNoJugador(), vacio, espaciojugado));
        textX.setFont(Font.font("System", 96));
        textX.setFill(Paint.valueOf("#bdf271"));
        textX.setLayoutY(pane.getHeight() / 2 + 30);
        textX.setLayoutX(pane.getWidth() / 2 - 30);
        pane.getChildren().add(textX);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        juego = new Juego();
        jugador1 = new Jugador("Fabian");
        jugador2 = new Jugador("Fabian 2");
    }
}
