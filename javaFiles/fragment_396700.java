public static void main(String[] args) {
    JFrame window = new JFrame();
    Main myMain = new Main();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 600, 584);
    window.getContentPane().add(myMain);
//    window.setResizable(false);
    window.setVisible(true);    
    window.addMouseListener(myMain);
  }