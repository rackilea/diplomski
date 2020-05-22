import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {       
    private final JPanel mainPanel;
    private final JButton editButton;

    public MyFrame() {
        mainPanel = new JPanel();
        editButton = new JButton("Edit");
        mainPanel.add(editButton);
    }
}