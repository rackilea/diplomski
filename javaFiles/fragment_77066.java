public CardLay() {
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   setSize(500, 400);

   ca = new CardLayout(0, 0);

   contentPane = new JPanel();
   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
   contentPane.setLayout(ca);

   JPanel panel1 = new JPanel();
   panel1.add(new JButton("Test Button"));
   contentPane.add("card1", panel1);

   JPanel panel2 = new JPanel();
   contentPane.add("card2", panel2);
   JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
   panel2.add(chckbxNewCheckBox);

   JPanel navigationPanel = new JPanel();

   JButton btnPrevious = new JButton("< PREVIOUS");
   btnPrevious.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        ca.previous(contentPane);
    }
   });
   navigationPanel.add(btnPrevious);

   JButton btnNext = new JButton("NEXT >");
   btnNext.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
      ca.next(contentPane);
    }
   });
   navigationPanel.add(btnNext);

   add(contentPane);
   add(navigationPanel, BorderLayout.SOUTH);
}