public class Machinery {

    private final Consumer<String> textProcessor ;

    public Machinery(Consumer<String> textProcessor) {
        this.textProcessor = textProcessor ;
    }

    public void doMachineryWork() {
        // all the process here, and to update the label you do
        textProcessor.accept("Some new text");
        // etc etc
    }
}