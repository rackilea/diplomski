JButton captureKeyButton = new JButton("Capture key");
JLabel captureText = new JLabel("");
KeyListener keyListener = new KeyAdapter(){
   public void keyReleased(KeyEvent e){
       KeyStroke ks = KeyStroke.getKeyStroke(e.getKeyCode(), e.getModifiers());
       menuItem.setAccelerator(ks);
       captureText.setText("Key captured: "+ks.toString());
       captureKeyButton.removeKeyListener(this);
   }
};
ActionListener buttonClicked = new ActionListener(){
   public void actionPerformed(ActionEvent e){
       captureKeyButton.addKeyListener(keyListener);
       captureText.setText("Please type a menu shortcut");
   }
};
captureKeyButton.addActionListener(buttonClicked);