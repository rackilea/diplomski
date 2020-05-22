public JTask() throws IOException {
    JFrame  frame = new JFrame();
    JTextArea  area = new JTextArea();
    area.setFont(new Font("monospaced", Font.PLAIN, 14));
    JScrollPane  scrollPane = new JScrollPane(area);
    frame.add(scrollPane);
    ...
    // set text in JTextArea
    ...
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}