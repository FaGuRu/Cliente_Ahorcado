package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        //Quita el marco
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Cliente");
        Parent root = FXMLLoader.load(getClass().getResource("View/root.fxml"));
        Scene scene = new Scene(root);
        // Establecer el color de relleno del Scene a transparente
        scene.setFill(Color.TRANSPARENT);
        // Agregar el archivo de estilos style.css
        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        stage.setScene(scene);
        stage.show();
        stage.setX(800);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
