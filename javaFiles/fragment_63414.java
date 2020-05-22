import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.*;
import javafx.util.Callback;

/**
 * Demonstrates a modal WebView confirm box in JavaFX.
 * Dialog is rendered upon a blurred background.
 * Dialog is translucent.
 * Requires JavaFX 2.2
 * To test, run the program, then click the "Try it" button in the Result textarea.
 */
public class WebViewConfirm extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(final Stage primaryStage) {
    // initialize the stage
    primaryStage.setTitle("Modal Confirm Example");
    final WebView webView = new WebView();
    webView.getEngine().load("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

    // layout the stage - a vbox to show confirmation results and a webview to generate confirmations.
    final VBox confirmationResults = new VBox();
    confirmationResults.getStyleClass().add("confirmation-results");
    confirmationResults.setMinWidth(150);
    HBox layout = new HBox();
    layout.getChildren().addAll(confirmationResults, webView);
    primaryStage.setScene(new Scene(layout));
    primaryStage.show();
    primaryStage.getScene().getStylesheets().add(getClass().getResource("modal-dialog.css").toExternalForm());

    // show the confirmation dialog each time a new page is loaded and
    // record the confirmation result.
    webView.getEngine().setConfirmHandler(new Callback<String, Boolean>() {
      @Override public Boolean call(String msg) {
        Boolean confirmed = confirm(primaryStage, msg);
        confirmationResults.getChildren().add(new Label("Confirmed? " + confirmed));
        return confirmed;
      }
    });
  }

  private Boolean confirm(final Stage parent, String msg) {
    final BooleanProperty confirmationResult = new SimpleBooleanProperty();
    // initialize the confirmation dialog
    final Stage dialog = new Stage(StageStyle.TRANSPARENT);
    dialog.initOwner(parent);
    dialog.initModality(Modality.WINDOW_MODAL);
    dialog.setScene(
      new Scene(
        HBoxBuilder.create().styleClass("modal-dialog").children(
          LabelBuilder.create().text(msg).build(),
          ButtonBuilder.create().text("OK").defaultButton(true).onAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
              // take action and close the dialog.
              confirmationResult.set(true);
              parent.getScene().getRoot().setEffect(null);
              dialog.close();
            }
          }).build(),
          ButtonBuilder.create().text("Cancel").cancelButton(true).onAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
              // abort action and close the dialog.
              confirmationResult.set(false);
              parent.getScene().getRoot().setEffect(null);
              dialog.close();
            }
          }).build()
        ).build()
        , Color.TRANSPARENT
      )
    );

    // allow the dialog to be dragged around.
    final Node root = dialog.getScene().getRoot();
    final Delta dragDelta = new Delta();
    root.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        // record a delta distance for the drag and drop operation.
        dragDelta.x = dialog.getX() - mouseEvent.getScreenX();
        dragDelta.y = dialog.getY() - mouseEvent.getScreenY();
      }
    });
    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent mouseEvent) {
        dialog.setX(mouseEvent.getScreenX() + dragDelta.x);
        dialog.setY(mouseEvent.getScreenY() + dragDelta.y);
      }
    });

    // style and show the dialog.
    dialog.getScene().getStylesheets().add(getClass().getResource("modal-dialog.css").toExternalForm());
    parent.getScene().getRoot().setEffect(new BoxBlur());
    dialog.showAndWait();

    return confirmationResult.get();
  }

  // records relative x and y co-ordinates.
  class Delta { double x, y; }
}