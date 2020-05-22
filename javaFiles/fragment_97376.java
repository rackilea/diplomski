package com.example.app;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static java.lang.System.getProperty;

public class Main extends Application {

  private static void launchProcess() {
    try {
      new ProcessBuilder(
              Path.of(getProperty("java.home"), "bin", "java").toString(),
              "--class-path",
              getProperty("java.class.path"),
              Launcher.class.getName())
          .inheritIO()
          .start();
    } catch (IOException ex) {
      throw new UncheckedIOException(ex);
    }
  }

  @Override
  public void start(Stage primaryStage) {
    Button launchBtn = new Button("Launch process");
    launchBtn.setOnAction(
        event -> {
          event.consume();
          launchProcess();
        });
    primaryStage.setScene(new Scene(new StackPane(launchBtn), 500, 300));
    primaryStage.setTitle("Multi-Process Example");
    primaryStage.show();
  }
}