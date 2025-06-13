package projectFinal;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Metode start() adalah metode utama dari JavaFX.
     * 
     * @param primaryStage Panggung utama atau window utama yang disediakan oleh
     *                     JavaFX.
     */
    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/MainView.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Rumah Impian - Properti Simulator");

            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Gagal memuat file FXML: MainView.fxml");
            e.printStackTrace();
        }
    }

    /**
     * Metode main() adalah titik masuk standar untuk aplikasi Java.
     * Tugasnya hanya satu: meluncurkan aplikasi JavaFX.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}