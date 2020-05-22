int[][] board;
int dim;
int[] NS, SN, EW, WE; //the outter arrays

public SkyscraperConfig(Scanner f){
  //First line should be dimension line
  int dim = Integer.parseInt(f.nextLine());

  //Initalize data structures based off of this dimension
  this.NS = new int[dim];
  this.SN = new int[dim];
  this.EW = new int[dim];
  this.WE = new int[dim];
  this.board = new int[dim][dim];

  //Read in side arrays
  //...

  //Read in the board
  //...
}