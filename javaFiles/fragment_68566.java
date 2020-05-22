public class ExerciseView extends HBox {

    @FXML
    private Label exerciseLabel ;
    @FXML
    private Label mainMuscleLabel ;
    @FXML
    private Label equipmentLabel ;

    public ExerciseView(Resource exercise, Resource mainMuscle, Literal equipment) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Exercise.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
            mainMuscleLabel.setText(mainMuscle.getLocalName());
            equipmentLabel.setText(equipment.getString());
            exerciseLabel.setText(exercise.getLocalName());
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    // ...
}