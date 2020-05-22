import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {       
    JPanel mainPanel = new JPanel();
    JButton editButton = new JButton("Edit");

    public MyFrame() {
        mainPanel.add(editButton);
    }
}