List<Piece> pieces = new ArrayList<>();
    pieces.add(new Piece("R", 5));
    pieces.add(new Piece("P", 1));
    pieces.add(new Piece("Q", 9));
    pieces.add(new Piece("K", 10));
    pieces.add(new Piece("R", 5));
    pieces.add(new Piece("P", 1));

    Collections.sort(pieces);

    System.out.println(pieces);  //Prints [Piece{symbol='P', value=1}, Piece{symbol='P', value=1}, Piece{symbol='R', value=5}, Piece{symbol='R', value=5}, Piece{symbol='Q', value=9}, Piece{symbol='K', value=10}]