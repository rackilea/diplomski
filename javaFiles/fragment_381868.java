private void addSecond() {
    JButton secondButton = new JButton("Button - 2");

    this.setLayout(new BorderLayout());
    remove(firstButton);
    add(firstButton, BorderLayout.NORTH);
    add(secondButton, BorderLayout.CENTER);

    revalidate();
}