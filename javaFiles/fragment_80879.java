import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AutoCompleteTextAreaTest extends Application {

    private static final String WORD_LIST_URL = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt?raw=true";

    @Override
    public void start(Stage primaryStage) {

        StackPane loadingRoot = new StackPane(new ProgressBar());
        Scene scene = new Scene(loadingRoot, 600, 600);


        List<String> words = new ArrayList<>();

        Task<List<String>> loadWordsTask = new Task<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(WORD_LIST_URL)
                        .openConnection()
                        .getInputStream()))) {

                    return in.lines()
                            .collect(Collectors.toList());
                }
            }

        };

        ListView<String> suggestions = new ListView<>();

        TextArea textArea = new TextArea();


        textArea.caretPositionProperty().addListener((obs, oldPosition, newPosition) -> {
            String text = textArea.getText().substring(0, newPosition.intValue());
            int index ;

            for (index = text.length() - 1; 
                    index >= 0 && ! Character.isWhitespace(text.charAt(index)); 
                    index--);
            String prefix = text.substring(index+1, text.length());

            for (index = newPosition.intValue(); 
                    index < textArea.getLength() && ! Character.isWhitespace(textArea.getText().charAt(index)); 
                    index++);
            String suffix = textArea.getText().substring(newPosition.intValue(), index);

            // replace regex wildcards (literal ".") with "\.". Looks weird but correct...
            prefix = prefix.replaceAll("\\.", "\\.");
            suffix = suffix.replaceAll("\\.", "\\.");

            Pattern pattern = Pattern.compile(prefix+".*"+suffix, 
                    Pattern.CASE_INSENSITIVE);

            suggestions.getItems().setAll(
                words.stream().filter(word -> pattern.matcher(word).matches())
                .sorted(Comparator.comparing(String::length))
                .limit(100)
                .collect(Collectors.toList())
            );
        });


        BorderPane root = new BorderPane(textArea, null, suggestions, null, null);

        loadWordsTask.setOnSucceeded(e -> {
            words.addAll(loadWordsTask.getValue());
            scene.setRoot(root);
        });

        loadWordsTask.setOnFailed(e -> {
            suggestions.setPlaceholder(new Label("Could not load word list"));
            loadWordsTask.getException().printStackTrace();
            scene.setRoot(root);
        });

        Thread t = new Thread(loadWordsTask);
        t.setDaemon(true);
        t.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}