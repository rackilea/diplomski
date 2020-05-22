public class ... {
    //...
    private Map<JLabel> labels = new HashMap<JLabel>();
    //...

    protected void someMethodThatYouCall() {
        // Probably some kind of loop
        labels.put(text, createButton(x, y, text));
    }
}