JFrame frame = new JFrame ("Test");
JLabel label = new JLabel ("Font Test");
label.setFont (label.getFont ().deriveFont (64.0f));
frame.getContentPane ().add (label);
frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
frame.pack ();
frame.setVisible (true);