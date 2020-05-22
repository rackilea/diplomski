JPanel graphpanel = new JPanel();
  graphpanel.setBackground(Color.white);
  graphpanel.setPreferredSize(new Dimension(420,420));
  DrawGraph drawgraph = new DrawGraph();
  graphpanel.add(drawgraph);
  panel.add(graphpanel,BorderLayout.CENTER);