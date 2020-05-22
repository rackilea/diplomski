setTitle("Playing With The Mouse!"); // An applet has no title 
    // (Though it might have an ID/name in HTML)
setSize(400, 400);  // Set in HTML
setResizable(false); // An applet is usually fixed size
setVisible(true); // Not relevant to an applet (visible by default)
addMouseListener(this); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Not allowed in an applet
show(); // Deprecated for components around 1.2, for TLCs around 1.5, ..
    // ..and redundant