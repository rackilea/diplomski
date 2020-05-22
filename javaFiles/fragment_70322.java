package test;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DragDetectedHandler implements EventHandler<MouseEvent> {

private String test;

public DragDetectedHandler(String test) {
    this.test = test;
}

@Override
public void handle(MouseEvent mouseEvent) {
    System.out.println("Handle stuff here :)");
}
}