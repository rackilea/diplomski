public static void go(){    // no need to implement actionListener
    JFrame j = new JFrame();
    j.setDefaultCloseOperation(EXIT_ON_CLOSE);
    j.setSize(640,480);

    final Screen screen = new Screen();
    j.add(BorderLayout.CENTER, screen);

    JButton button = new JButton("Click Me!");
    button.addActionListener(new ActionListener(){ // change are made here

        @Override
        public void actionPerformed(ActionEvent e) {  //& here
            screen.repaint();
        }
    });
    j.add(BorderLayout.NORTH, button);
    j.setVisible(true);
}