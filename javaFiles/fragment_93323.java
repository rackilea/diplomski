public class ... {
    //...
    private JLabel[] labels = new JLabel[26];
    //...

    protected void someMethodThatYouCall() {
        // Probably some kind of loop
        labels[indexOfNextLabel] = createButton(x, y, text);
    }
}