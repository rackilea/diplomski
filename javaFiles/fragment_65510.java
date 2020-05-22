public static void main(String[] args) {
    JFrame frame = new JFrame("Some practice");
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);

    Main doStuff = new Main();

    JButton myButton = new JButton("Button");
    JPanel controls = new JPanel();
    controls.setBorder(BorderFactory.createTitledBorder("Small Panel"));
    controls.add(myButton);
    frame.add("South", controls);

    frame.add(doStuff); // <-- you are still adding things.
    frame.setVisible(true);
}