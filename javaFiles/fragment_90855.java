import javax.swing.*;
import java.awt.*;

public class Example extends JFrame {

    public Example() {

        JPanel topLeftPanel = new JPanel();
        JPanel topRightPanel = new JPanel();
        JPanel bottomLeftPanel = new JPanel();
        JPanel bottomRightPanel = new JPanel();

        JSplitPane topPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, topLeftPanel, topRightPanel);

        JSplitPane bottomPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, bottomLeftPanel, bottomRightPanel);

        topPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, pce -> {
            bottomPane.setDividerLocation((int) pce.getNewValue());
        });

        bottomPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, pce -> {
            topPane.setDividerLocation((int) pce.getNewValue());
        });

        JSplitPane mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPane, bottomPane);

        setContentPane(mainPane);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(400, 400));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}