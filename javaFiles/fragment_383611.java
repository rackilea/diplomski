JPanel centerPanel = new JPanel(new GridBagLayout()); 

   JLabel label1 = new JLabel("center1");
   JLabel label2 = new JLabel("center2");

   JPanel flowPanel = new JPanel(new FlowLayout());
   flowPanel.add(label1);
   flowPanel.add(label2);

   centerPanel.add(flowPanel);