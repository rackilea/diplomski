import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Properties
        DataHelper dataHelper = new DataHelper("Word", "Meaning", "Sentence");
        AtomicInteger i = new AtomicInteger(0);

        // UI elements
        Label wordLabel = new Label();
        Label meaningLabel = new Label();
        Label sentenceLabel = new Label();
        Button startService = new Button("Start");

        Service<DataHelper> service = new Service<DataHelper>() {
            @Override
            protected Task<DataHelper> createTask() {
                return new Task<DataHelper>() {
                    @Override
                    protected DataHelper call() throws Exception {
                        i.incrementAndGet();
                        return new DataHelper("Word " + i, "Meaning " + i, "Sentence " + i);
                    }
                };
            }
        };

        startService.setOnAction(e -> {
            if(service.getState().equals(Worker.State.READY) || service.getState().equals(Worker.State.SUCCEEDED)) {
                service.restart();
            }
        });

        service.setOnSucceeded(event -> {
            dataHelper.setWord(service.getValue().getWord());
            dataHelper.setMeaning(service.getValue().getMeaning());
            dataHelper.setSentence(service.getValue().getSentence());
        });

        wordLabel.textProperty().bind(dataHelper.wordProperty());
        meaningLabel.textProperty().bind(dataHelper.meaningProperty());
        sentenceLabel.textProperty().bind(dataHelper.sentenceProperty());

        VBox box = new VBox(10, wordLabel, meaningLabel, sentenceLabel, startService);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class DataHelper {
        StringProperty word = new SimpleStringProperty();
        StringProperty meaning = new SimpleStringProperty();
        StringProperty sentence = new SimpleStringProperty();

        public DataHelper(String word, String meaning, String sentence) {
            this.word.setValue(word);
            this.meaning.setValue(meaning);
            this.sentence.setValue(sentence);
        }

        public String getMeaning() {
            return meaning.get();
        }

        public StringProperty meaningProperty() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning.set(meaning);
        }

        public String getSentence() {
            return sentence.get();
        }

        public StringProperty sentenceProperty() {
            return sentence;
        }

        public void setSentence(String sentence) {
            this.sentence.set(sentence);
        }

        public String getWord() {
            return word.get();
        }

        public StringProperty wordProperty() {
            return word;
        }

        public void setWord(String word) {
            this.word.set(word);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}