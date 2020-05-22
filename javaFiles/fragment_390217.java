public class Example extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

    JFrame go = new JFrame("Example");
    JPanel panel = new JPanel();
    GridBagLayout Grid = new GridBagLayout();
    JLabel Title = new JLabel("LARGE TITLE", SwingConstants.CENTER);
    JLabel Label1 = new JLabel("Label 1", SwingConstants.CENTER);
    JLabel Label2 = new JLabel("Label 2", SwingConstants.CENTER);


    JLabel anotherLabel1 = new JLabel("Another Label 1", SwingConstants.CENTER);
    JLabel anotherLabel2 = new JLabel("Another Label 2", SwingConstants.CENTER);

    JTextArea textArea1 = new JTextArea("TextArea 1");
    JTextArea textArea2 = new JTextArea("TextArea 2");

    public Example() {
        panel.setLayout(Grid);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        Title.setFont(new Font("Serif", Font.BOLD, 60));

        JButton button;
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40; //increase height of the title
        c.weightx = 0.5;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(Title, c);

        c.ipady = 0;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(Label1, c);

        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 2;
        c.gridy = 1;
        panel.add(Label2, c);

        c.ipady = 0;
        c.gridwidth = 1;
        c.weightx = 0.25;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(anotherLabel1, c);

        c.weightx = 0.25;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(textArea1, c);

        c.weightx = 0.25;
        c.gridx = 2;
        c.gridy = 2;
        panel.add(anotherLabel2, c);

        c.weightx = 0.25;
        c.gridx = 3;
        c.gridy = 2;
        panel.add(textArea2, c);

        button = new JButton("JButton");
        c.ipady = 0;
        c.weighty = 1.0;
        c.insets = new Insets(10, 0, 0, 0); 
        c.gridx = 1; 
        c.gridwidth = 2; 
        c.gridy = 3;
        panel.add(button, c);

        go.add(panel);
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.pack();
        go.setSize(750, 300);
        go.setVisible(true);
    }

}