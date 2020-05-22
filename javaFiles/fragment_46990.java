public Back(){
    super("title");
    setLayout(null);

    Icon i=new ImageIcon(getClass().getResource("1.png"));
    pane=new Container();

    thehandler hand=new thehandler();//konstruktori i handler merr nje instance te Background
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane().setBackground(Color.GREEN);
    setSize(700,500);
    setVisible(true);    
}