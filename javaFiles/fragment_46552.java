public void go(){
        JFrame frame = new JFrame();
        button = new JButton("Click");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);


} //close go()



public void actionPerformed(ActionEvent event){
            button.setText("I've been clicked.");
} //close actionPerformed