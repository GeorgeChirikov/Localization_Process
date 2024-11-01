package org.example.localization_process;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Label label1;


    public void initialize() {
//        ResourceBundle bundle = ResourceBundle.getBundle("bundle2");
//        button1.setText(bundle.getString("button1.text"));
//        button2.setText(bundle.getString("button2.text"));
//        button3.setText(bundle.getString("button3.text"));
    }


    public void setEN(ActionEvent actionEvent) {
        Locale locale = new Locale("EN");
        loadView(locale);
    }

    public void setIR(ActionEvent actionEvent) {
        Locale locale = new Locale("IR");
        loadView(locale);
    }

    public void setJP(ActionEvent actionEvent) {
        Locale locale = new Locale("JP");
        loadView(locale);
    }

    public void loadView(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(bundle);
        try {
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) button1.getScene().getWindow();
            stage.setScene(new Scene(root, 320, 240));

            HelloController controller = fxmlLoader.getController();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = LocalTime.now().format(formatter);

            String label1Text = MessageFormat.format(bundle.getString("label1.text"), formattedTime);
            controller.label1.setText(label1Text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}