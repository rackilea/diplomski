public static void main(String[] args) {

    int dim=10;
    int matrix[][] = new int[10][10];

    JFrame f = new JFrame("Window containing a matrix");
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(dim, dim));

    for(int r = 0; r < dim; r++){
        for(int c = 0; c < dim; c++){
            ChangingButton button= new ChangingButton(r, c, matrix);
            p.add(button);
        }
    }
    f.add(p);
    f.pack();
    f.setVisible(true);

}