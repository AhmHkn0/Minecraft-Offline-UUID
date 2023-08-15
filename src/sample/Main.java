package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        stage = primaryStage;
        setTitle();
        setIcon();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setTitle() {
        stage.setTitle("Minecraft Offline UUID");
    }

    public void setIcon() {
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resources/mc.png")));
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
