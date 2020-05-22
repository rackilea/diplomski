import java.util.stream.Stream;

import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ExpandingTextExample extends Application {

    // The following text is taken from the "JavaFX CSS Reference Guide":
    // http://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html 

    private static final String text = "Never has styling a Java UI been easier than "
            + "with JavaFX and Cascading Style Sheets (CSS). "
            + "Going from one theme to another, or "
            + "customizing the look of just one control, "
            + "can all be done through CSS. To the novice, "
            + "this may be unfamiliar territory; "
            + "but the learning curve is not that great. "
            + "Give CSS styling a try and the benefits will soon be apparent. "
            + "You can also split the design and development workflow, or "
            + "defer design until later in the project. "
            + "Up to the last minute changes, and even post-deployment "
            + "changes, in the UI's look can be achieved through JavaFX CSS. "
            + "\n"
            + "The structure of this document is as follows. "
            + "First, there is a description of all "
            + "value types for JavaFX CSS properties. "
            + "Where appropriate, this includes a grammar "
            + "for the syntax of values of that type. "
            + "Then, for each scene‑graph node that supports CSS styles, "
            + "a table is given that lists the properties that are supported, "
            + "along with type and semantic information. "
            + "The pseudo‑classes for each class are also given. "
            + "The description of CSS properties continues for the controls. "
            + "For each control, the substructure of that control's skin is given, "
            + "along with the style‑class names for the Region "
            + "objects that implement that substructure." ;

    private static final String NBSP = "\u2007" ;

    private final PseudoClass expanded = PseudoClass.getPseudoClass("expanded");

    @Override
    public void start(Stage primaryStage) {
        String[] words = text.split(" ");
        TextFlow flow = new TextFlow();
        flow.setLineSpacing(5);
        Stream.of(words)
            .map(s -> s.concat(" "))
            .map(Text::new)
            .peek(text -> text.getStyleClass().add("word"))
            .peek(text -> text.setOnMousePressed(event -> expand(text)))
            .forEach(flow.getChildren()::add);

        ScrollPane scroller = new ScrollPane();
        scroller.setFitToWidth(true);
        scroller.setContent(flow);

        Scene scene = new Scene(scroller, 600, 400);

        scene.getStylesheets().add("expanding-text.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void expand(Text text) {
        if (text.getPseudoClassStates().contains(expanded)) { //collapse:
            String[] letters = text.getText().split(NBSP);
            StringBuilder newText = new StringBuilder();
            Stream.of(letters).forEach(newText::append);
            text.setText(newText.toString());
            text.pseudoClassStateChanged(expanded, false);
        } else {
            String[] letters = text.getText().split("");
            text.setText(String.join(NBSP, letters));
            text.pseudoClassStateChanged(expanded, true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}