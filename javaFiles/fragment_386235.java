Ellipse(String s){
        super(s);
        setLocation(40,40);
        setLayout(new FlowLayout());
        setSize(300,300);
        setBackground(Color.white);
        Font serif = new Font("Serif", 1, 10);
        setFont(serif);
        Label label = new Label("Ellipse 1",1);
        add(label);
        pack(); // size the frame
        setVisible(true);
}