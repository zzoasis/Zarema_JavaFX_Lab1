/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zarema_lab1;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Зарема
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField textInputA;
    @FXML
    private TextField textInputB;
    @FXML
    private TextField textInputX;
    @FXML
    private TextField textInputD;
    @FXML
    private Label textResult;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void solve(ActionEvent event) {
        double a,b,x,y;
        try {
            a = Double.parseDouble(textInputA.getText());
            b = Double.parseDouble(textInputB.getText());
            x = Double.parseDouble(textInputX.getText());
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введения данных!", "Ошибка ввода!", JOptionPane.ERROR_MESSAGE);
            textInputA.requestFocus();
            textResult.setText("В введенных значениях допущены ошибки");
            textInputA.setText("");
            textInputB.setText("");
            textInputX.setText("");
            return;
        }
        if (x >= 5) {
            y = ((5 * (a*a + b*b)) / (x - 4));
            
        } else {
            y = (6*a*b-5*x);
            
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            textResult.setText("Ответ: " + String.format("%.2f", y));
        } else {
            textResult.setText("Нет ответа");
        }
    }

    @FXML
    private void clean(ActionEvent event) {
        textResult.setText("Ответ: ");
        textInputA.setText("");
        textInputB.setText("");
        textInputX.setText("");
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }
    
}
