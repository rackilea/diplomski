public class growAndShrinkListener implements ActionListener {

    private JButton button;

    growAndShrinkListener() {

        button = new JButton("Click me to grow the Square");
        frame.add(button, BorderLayout.NORTH);
        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("Click to shrink square");
    }
}