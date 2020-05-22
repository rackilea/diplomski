@Override
public void run() {
        MyPanel panel = new MyPanel();
        panel.buildGUI();
        frame.add(panel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}

...

public class MyPanel extends JPanel {

    public void buildGUI() {
        bottomPanel = new JPanel(); 
        bottomPanel.setLayout(new GridBagLayout());
        // build gui here, add components to bottomPanel
        this.add(bottomPanel);
    }
}