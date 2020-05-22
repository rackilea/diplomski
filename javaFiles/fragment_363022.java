class Gui {

    void create() {
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> startSomething());
    }

    private void startSomething() { ... }
}