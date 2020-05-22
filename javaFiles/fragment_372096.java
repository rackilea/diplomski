//!! JScrollPane scrollPaneB = new JScrollPane();
  //!! scrollPaneB.setSize(200, 200);
  String[] listB = { "Some content on the right panel", "More content",
        "Some more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content" };
  JList listBottom = new JList(listB);
  listBottom.setVisibleRowCount(12);
  JScrollPane scrollPaneB = new JScrollPane(listBottom);
  panelBottom.add(scrollPaneB);
  //!! scrollPaneB.add(listBottom);
  scrollPaneB.setBorder(BorderFactory.createTitledBorder("Bottom Panel"));
  scrollPaneB.setVisible(true);
  // !! listBottom.setVisible(true);

  JPanel panelCenter = new JPanel();
  frame.getContentPane().add(panelCenter, BorderLayout.CENTER);
  panelCenter.setLayout(new GridLayout(0, 2, 0, 0));

  //!! JScrollPane scrollPaneL = new JScrollPane();
  // !! scrollPaneL.setSize(200, 200);
  String[] listL = { "Some content on the right panel", "More content",
        "Some more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content" };
  JList listLeft = new JList(listL);
  listLeft.setVisibleRowCount(12);
  JScrollPane scrollPaneL = new JScrollPane(listLeft);
  panelCenter.add(scrollPaneL);
  // !! scrollPaneL.add(listLeft);
  scrollPaneL.setBorder(BorderFactory.createTitledBorder("Top Left Panel"));
  // !! scrollPaneL.setVisible(true);
  // !! listLeft.setVisible(true);

  //!! JScrollPane scrollPaneR = new JScrollPane();
  //!! scrollPaneR.setSize(200, 200);
  String[] listR = { "Some content on the right panel", "More content",
        "Some more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content", "More and more content",
        "More and more content" };
  JList listRight = new JList(listR);
  listRight.setVisibleRowCount(12);
  JScrollPane scrollPaneR = new JScrollPane(listRight); //!! 
  panelCenter.add(scrollPaneR);
  //!! scrollPaneR.add(listRight);
  scrollPaneR.setBorder(BorderFactory.createTitledBorder("Top Right Panel"));
  //!! scrollPaneR.setVisible(true);
  //!! listRight.setVisible(true);