public Main(Color c) {
   setSize(800, 600);
   setVisible(true);
   setResizable(true);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLocationRelativeTo(null);
   Color = c;
   setBackground(Color); 
   init();
}