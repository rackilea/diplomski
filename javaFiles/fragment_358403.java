import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    TextArea taWords = new TextArea("Tak Carrage thiss on hoemaker answe");
    TextField tfCurrentWordBeingChecked = new TextField();
    //TextField tfMisspelledWord = new TextField();
    ListView<String> lvReplacementWords = new ListView();
    TextField tfReplacementWord = new TextField();

    Button btnCheckSpelling = new Button("Check Spelling");
    Button btnReplaceWord = new Button("Replace Word");

    List<String> wordList = new ArrayList();
    List<String> returnList = new ArrayList();
    HandleLevenshteinDistance handleLevenshteinDistance = new HandleLevenshteinDistance();
    ObservableList<String> listViewData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage)
    {
        setupListView();
        handleBtnCheckSpelling();
        handleBtnReplaceWord();

        VBox root = new VBox(taWords, tfCurrentWordBeingChecked, lvReplacementWords, tfReplacementWord, btnCheckSpelling, btnReplaceWord);
        root.setSpacing(5);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void handleBtnCheckSpelling()
    {
        btnCheckSpelling.setOnAction(actionEvent -> {
            if (btnCheckSpelling.getText().equals("Check Spelling")) {
                wordList = new ArrayList(Arrays.asList(taWords.getText().split(" ")));
                returnList = new ArrayList(Arrays.asList(taWords.getText().split(" ")));
                loadWord();
                btnCheckSpelling.setText("Check Next Word");
            }
            else if (btnCheckSpelling.getText().equals("Check Next Word")) {
                loadWord();
            }
        });
    }

    public void handleBtnReplaceWord()
    {
        btnReplaceWord.setOnAction(actionEvent -> {
            int indexOfWordToReplace = returnList.indexOf(tfCurrentWordBeingChecked.getText());
            returnList.set(indexOfWordToReplace, tfReplacementWord.getText());
            taWords.setText(String.join(" ", returnList));
            btnCheckSpelling.fire();
        });
    }

    public void setupListView()
    {
        lvReplacementWords.setItems(listViewData);
        lvReplacementWords.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            tfReplacementWord.setText(newSelection);
        });
    }

    private void loadWord()
    {
        if (wordList.size() > 0) {
            tfCurrentWordBeingChecked.setText(wordList.get(0));
            wordList.remove(0);
            showPotentialCorrectSpellings();
        }
    }

    private void showPotentialCorrectSpellings()
    {
        List<String> potentialCorrentSpellings = handleLevenshteinDistance.getPotentialCorretSpellings(tfCurrentWordBeingChecked.getText().trim());
        listViewData.setAll(potentialCorrentSpellings);
    }
}