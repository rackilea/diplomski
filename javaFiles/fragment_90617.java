class DrawingFrame extends JFrame{
    public DrawingFrame(){
        super("TEST");
        this.setSize(600,500);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolbar top = new Toolbar();
        top.setBounds(0, 0, 150, 150);
        this.add(top);

    }
}

class Toolbar extends JPanel{

    public Toolbar(){

        this.setLayout(null);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(150,150));
        this.setBackground(Color.RED);

        JButton buton = new JButton("Hello!");
        buton.setBounds(40, 40, 40, 40);

        this.add(buton);

    }
}