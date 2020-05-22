public class growAndShrinkListener implements ActionListener {



    growAndShrinkListener(JButton button) {

        button = new JButton("Click me to grow the Square");
        frame.add(button, BorderLayout.NORTH);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source instanceof JButton) {
            button = (JButton) source;
            button.setText("Click to shrink square");
        }
    }
}