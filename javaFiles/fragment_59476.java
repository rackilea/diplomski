import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.net.*;
import java.nio.file.*;

public class HTMLEditorLineDisplay extends Application {
    private static final String TEXT_LOCATION =
            "http://www.textfiles.com/etext/AUTHORS/SHAKESPEARE/shakespeare-life-54.txt";

    private StringBuilder textBuilder = new StringBuilder();

    @Override
    public void init() throws Exception {
        // sample data from the internet placed in a temporary file.
        Path tmpFile = Files.createTempFile("html-editor-text", ".txt");
        Files.copy(
                new URL(TEXT_LOCATION).openStream(),
                tmpFile,
                StandardCopyOption.REPLACE_EXISTING
        );

        // read lines from a file, appending a pre-formatting tag.
        textBuilder.append("<pre>");
        Files.lines(tmpFile)
                .forEach(
                        line -> textBuilder.append(line).append("\n")
                );
        textBuilder.append("</pre>");

        Files.delete(tmpFile);
    }

    @Override public void start(Stage stage) {
        // load pre-formatted text into the html editor.
        HTMLEditor editor = new HTMLEditor();
        editor.setHtmlText(textBuilder.toString());
        textBuilder = new StringBuilder();

        stage.setScene(new Scene(editor));
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}