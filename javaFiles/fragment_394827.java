public static void main(String[] args){
    JFrame f = new JFrame();
    f.add(new MyPanel(), BorderLayout.CENTER);
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}