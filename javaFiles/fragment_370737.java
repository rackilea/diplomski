import java.awt.*;
import javax.swing.*;

public class WrapTestApp extends JFrame {
    public static void main(final String[] arguments) {
        new WrapTestApp();
    }

    public WrapTestApp() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(800, 400, 200, 200);
        getContentPane().setLayout(new BorderLayout());
        final CustomTextPane textPane = new CustomTextPane(true);
        final JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        textPane.setText("ExampleOfTheWrapLongWordWithoutSpaces");
        setVisible(true);
    }
}