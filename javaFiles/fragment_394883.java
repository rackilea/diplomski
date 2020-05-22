public gooey(RootPaneContainer c){
  c.getRootPane().setJMenuBar(mb);
  mb.add(mnuFile);       
  mb.add(mnuHelp);
  pnlNorth.add(btnNorth);
  c.getContentPane().setLayout(new BorderLayout());
  c.getContentPane().add(pnlNorth, BorderLayout.NORTH);