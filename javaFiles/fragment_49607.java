public Test()
  {
    setUI(new javax.swing.plaf.metal.MetalScrollPaneUI(){
      public void installListeners(JScrollPane scrollPane){}
    });
    JPanel canvas = new JPanel();
    canvas.add( new JLabel("Test") );

    setViewportView( canvas );
    setVisible(true);
  }