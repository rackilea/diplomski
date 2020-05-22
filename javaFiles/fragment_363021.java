class Gui {

    void create() {
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                startSomething();
            }
        });
    }

    private void startSomething() { ... }
}