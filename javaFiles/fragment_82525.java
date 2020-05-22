try{
    URL resource = ChessBoard2.class.getClassLoader().getResource("chess-pawn-f.png");
    img = ImageIO.read(resource);
    piece = new ImageIcon(img);
 }
 catch (IOException e)
 {
    e.printStackTrace();
 }