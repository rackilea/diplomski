JButton button;

void perform(){
    JFrame frame = new JFrame();
    button = new JButton("Button");
    frame.getContentPane().add(button) ;
    frame.setSize(300,300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button.addActionListener(this);
 }