public SkyscraperConfig(Scanner f){
  //First line should be dimension line
  int dim = Integer.parseInt(f.nextLine());

  //Only actual initialization we have to do is for the matrix's outer array
  board = new int[dim][];

  //Read in side arrays
  NS = parseIntLine(f.nextLine());
  EW = parseIntLine(f.nextLine());
  SN = parseIntLine(f.nextLine());
  WE = parseIntLine(f.nextLine());

  //Read in the board - dim rows to read
  for(int i = 0; i < dim; i++){
    board[i] = parseIntLine(f.nextLine());
  }

  f.close();
}