// Declaring the buttons, panels, etc...
JButton button = new JButton("Click");
final JLabel label = new JLabel();

button.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        clicked++;
        label.setText("Button pressed " + clicked + " times!");
    }
});

JPanel panel = new JPanel();
panel.add(button);
panel.add(label);

final JFrame frame = new JFrame("Button Pressed");
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
frame.add(panel);
frame.setVisible(true);