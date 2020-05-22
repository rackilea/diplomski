public class LabelFlow extends FlowPane {

    private List<Label> labels ;

    public LabelFlow(@NamedArg("numLabels") int numLabels) {
        labels = new ArrayList<>();
        for(int i = 1 ; i <= numLabels ; i++) {
            Label label = new Label("Label "+i);
            labels.add(label);
        }
        getChildren().addAll(labels);
    }

    public List<Label> getLabels() {
        return Collections.unmodifiableList(labels);
    }
}