MyFrame(){

    super("Calculator");
    JPanel p = new JPanel();
    grid = new GridLayout(4, 4, 3, 3);//row, col, hor gap, vert gap
    p.setLayout(grid);
    setSize(400, 500);
    setResizable(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    //create buttons
    for(int i = 0; i < buttonValues.length; i++){
        p.add(new JButton(buttonValues[i]));
    }
    add(p);

    setVisible(true);

}