public FantaFrame(HashMap<String, JPanel> fantaPanels) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("FantaCalcio App");
    setSize(500, 500);
    cardPanel.setLayout(cardLayout);
    add(cardPanel, BorderLayout.CENTER); // ****** add this line ******
    setPanels(fantaPanels);
}