public MainFrame() {
    this.setLayout(new MigLayout("debug, filly", "[grow, fill]", ""));
    this.add(new JButton("Test1"), "wrap");
    this.add(new JButton("Test2"), "wrap");
    this.add(new JButton("Test..."), "wrap");
    this.add(new JButton("TestBottom"), "push, bottom");
}