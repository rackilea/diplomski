JFrame jf=new JFrame("Test me");
    GridLayout gl=new GridLayout(5,5,20,20);
    jf.setLayout(gl);

    jf.setSize(500, 500);
    jf.setVisible(true);

    // create 10 new JLabel
    JLabel jp =new JLabel("ab");
    JLabel jp1 =new JLabel("ab");
    JLabel jp2 =new JLabel("ab");
    JLabel jp3 =new JLabel("ab");
    JLabel jp4 =new JLabel("ab");
    JLabel jp5 =new JLabel("ab");
    JLabel jp6 =new JLabel("ab");
    JLabel jp7 =new JLabel("ab");
    JLabel jp8 =new JLabel("ab");
    JLabel jp9 =new JLabel("ab");

    // add all 10
    jf.add(jp);
    jf.add(jp1);
    jf.add(jp2);
    jf.add(jp3);
    jf.add(jp4);
    jf.add(jp5);
    jf.add(jp6);
    jf.add(jp7);
    jf.add(jp8);
    jf.add(jp9);

    // Packs all components neatly in the Frame
    jf.pack();