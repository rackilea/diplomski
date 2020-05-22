Image piece1;

public Checkers(){
    piece1 = getImage("Piece_1.png");
}

public void paint(Graphics g){
    if (piece1!=null){
        g.drawImage(piece1, xcoord, ycoord, null);
    }
}