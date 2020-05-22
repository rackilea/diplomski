//frame.setLayout(new FlowLayout()); - comment out -  use default (Borderlayout)
    JLabel lbl= new JLabel();
    lbl.setIcon(icon);
    JScrollPane jsp = new JScrollPane(lbl); //warp the label with a scrollpane 
    //frame.add(lbl); 
    frame.add(jsp); //add scrollpane to frame instead of lbl