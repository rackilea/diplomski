import javax.swing.JFrame;
import javax.swing.JTextArea;
// ...

public class Main extends JFrame {
    private JTextArea textArea;

    private void createUI() {
        // ...
        textArea = new JTextArea();
        // ...
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}

public class Other {
    // ...
    public void update(Main main, String message) {
        main.getTextArea().setText(message);
    }
    // ...
}