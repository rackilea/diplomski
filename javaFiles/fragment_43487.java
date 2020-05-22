public class MyPanel extends JPanel {
    private long secretInfo = ...

    // refuse to be serialized!
    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new IllegalStateException("MyPanel cannot be serialized");
    }
}