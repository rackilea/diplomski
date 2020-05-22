public JColor() {
    super("String Painting Fun");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(myButton, BorderLayout.SOUTH);
    setDefaultLookAndFeelDecorated(true);
    getContentPane().setBackground(Color.BLUE);//<- update
}