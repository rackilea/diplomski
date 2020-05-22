public FenetreEditeur(){
    JFrame frame = new JFrame();
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    initMenuBar(frame);

    JTextArea areaMain = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(areaMain);

    frame.add(scrollPane);
    frame.setVisible(true);
}