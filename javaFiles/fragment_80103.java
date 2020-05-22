import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/** @see https://stackoverflow.com/a/59334974/230513 */

public class FinalGUI extends Application {

    private final List<String> backList = new ArrayList<>();
    private final List<String> chestList = new ArrayList<>();
    private final List<String> legList = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Your Work Out Friend");

        Label label = new Label("Choose your muscle group and your workout goal.");

        ComboBox<String> choiceMuscle = new ComboBox<>();
        ObservableList<String> choicesMuscle = FXCollections.observableArrayList(
            "Chest day", "Back day", "Leg day");
        choiceMuscle.setItems(choicesMuscle);
        choiceMuscle.getSelectionModel().select(0);

        ComboBox<String> choiceRep = new ComboBox<>();
        ObservableList<String> choicesRep = FXCollections.observableArrayList(
            "Lose weight", "Gain muscle mass", "Gain Strength");
        choiceRep.setItems(choicesRep);
        choiceRep.getSelectionModel().select(0);

        Button btnOK = new Button("Give me a workout!");

        Text text = new Text("\n\n\n");

        VBox vbox = new VBox(8);
        vbox.setPadding(new Insets(8));
        vbox.getChildren().addAll(label, choiceMuscle, choiceRep, btnOK, text);

        btnOK.setOnAction(a -> {
            String cMuscle = choiceMuscle.getSelectionModel().getSelectedItem();
            String muscleChoice = "";
            if (cMuscle.equalsIgnoreCase("Chest Day")) {
                muscleChoice = selectMuscles(chestDay());
            } else if (cMuscle.equalsIgnoreCase("Leg Day")) {
                muscleChoice = selectMuscles(legDay());
            } else if (cMuscle.equalsIgnoreCase("Back Day")) {
                muscleChoice = selectMuscles(backDay());
            }

            String cRep = choiceRep.getSelectionModel().getSelectedItem();
            String repChoice = "";
            if (cRep.equalsIgnoreCase("Lose Weight")) {
                repChoice = "5 sets of 20 reps, with 1 minute of cardio between";
            } else if (cRep.equalsIgnoreCase("Gain muscle mass")) {
                repChoice = "4 sets of 10 reps, or 5 sets of 8 reps";
            } else if (cRep.equalsIgnoreCase("Gain strength")) {
                repChoice = "5 sets of 3 reps, increasing the weight\n"
                    + "until you can no longer lift the weight.";
            }

            text.setText("Your workout: " + "\n" + muscleChoice + "\n" + repChoice);
        });

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    private String[] backDay() {
        if (backList.isEmpty()) {
            backList.add("Deadlift");
            backList.add("Pull Up");
            backList.add("Back Rows");
            backList.add("Bend-Over Barbell Rows");
            backList.add("Romanian Deadlift");
            backList.add("Front Squat");
        }
        return randomExercises(backList);
    }

    private String[] chestDay() {
        if (chestList.isEmpty()) {
            chestList.add("Bench Press");
            chestList.add("Incline Press");
            chestList.add("Dip");
            chestList.add("Flys");
            chestList.add("Reverse Flys");
            chestList.add("Supine Press");
        }
        return randomExercises(chestList);
    }

    private String[] legDay() {
        if (legList.isEmpty()) {
            legList.add("Squat");
            legList.add("Leg Press");
            legList.add("Leg Extension");
            legList.add("Dumbbell Step Up");
            legList.add("Body Weight Calf Raises");
            legList.add("Walking Lunge");
        }
        return randomExercises(legList);
    }

    private String[] randomExercises(List<String> arr) {
        Collections.shuffle(arr);
        return arr.subList(0, 3).toArray(new String[3]);
    }

    private String selectMuscles(String[] arr) {
        return (Arrays.toString(arr));
    }

    public static void main(String args[]) {
        Application.launch(args);
    }

}