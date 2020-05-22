import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CellFactories extends Application {    
    @Override
    public void start(Stage stage) {
        ObservableList<Word> wordsList = FXCollections.observableArrayList();
        wordsList.add(new Word("First Word", "Definition of First Word"));
        wordsList.add(new Word("Second Word", "Definition of Second Word"));
        wordsList.add(new Word("Third Word", "Definition of Third Word"));
        ListView<Word> listViewOfWords = new ListView<>(wordsList);
        listViewOfWords.setCellFactory(param -> new ListCell<Word>() {
            @Override
            protected void updateItem(Word item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getWord() == null) {
                    setText(null);
                } else {
                    setText(item.getWord());
                }
            }
        });
        stage.setScene(new Scene(listViewOfWords));
        stage.show();
    }

    public static class Word {
        private final String word;
        private final String definition;

        public Word(String word, String definition) {
            this.word = word;
            this.definition = definition;
        }

        public String getWord() {
            return word;
        }

        public String getDefinition() {
            return definition;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}