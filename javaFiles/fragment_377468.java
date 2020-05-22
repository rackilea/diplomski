class Incrementer implements ActionListener {
    private final Counter counter;
    private final JTextField textfield;
    Incrementer(Counter counter, JTextField textfield) {
        this.counter = counter;
        this.textfield = textfield;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        counter.increment();
        textfield.setText("Button Clicked " + counter.getCount() + " times");
    }
}