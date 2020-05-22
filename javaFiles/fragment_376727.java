//main frame settings
setTitle("Kingdom V " + Reference.version);
setSize(Reference.width, Reference.height);
setResizable(false);
setLocationRelativeTo(null);
//draw jpnael
getContentPane().add(menupaint);  //Moved this before setting Visible
this.pack();                      // call pack before setting visible
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(Kingdom.vissible);