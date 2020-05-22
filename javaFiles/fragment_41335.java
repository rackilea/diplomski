public class SwitchesTest {

   static private JTextArea lastClicked;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayJFrame();
            }
        });
    }

    static void displayJFrame() {
        JFrame frame = new JFrame("Switches");

        JButton button = new JButton("Switch");
        JTextArea switch1 = new JTextArea("On",1,3);
        JTextArea switch2 = new JTextArea("On",1,3);

        frame.getContentPane().setLayout(new GridBagLayout());

        frame.add(switch1);
        frame.add(switch2);
        frame.add(button);

        button.addActionListener(e -> {
            if( lastClicked != null ) 
              lastClicked.setText("On".equals( lastClicked.getText()) ? "Off" : "On");
        });

        switch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch1.setText("On".equals(switch1.getText()) ? "Off" : "On");
            lastClicked = switch1;
            }
        });

        switch2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch2.setText("On".equals(switch2.getText()) ? "Off" : "On");
            lastClicked = switch2;
            }
        });