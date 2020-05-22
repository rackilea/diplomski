package project.eHealth;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



@SpringBootApplication
public class EHealthApplication extends Application {
    private ConfigurableApplicationContext context;
    private Parent rootNode;
    private Stage primary;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        context = SpringApplication.run(EHealthApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // UI work should really be here, as it's on the FX Application Thread
        // (though I think you can get away with it in the init() method)
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        rootNode = fxmlLoader.load();
        this.primary = primaryStage;
        primaryStage.setScene(new Scene(rootNode));
        primaryStage.setTitle("E-Health Login");
        primaryStage.show();


    }

    @Override
    public void stop() throws Exception {
        context.close();
    }



}