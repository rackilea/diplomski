if (board1[pos_l].getAvail() == (true) && numClicks!=0) {
  if (key == 'y' ){
    board1 [pos_l].setAvail(false);
    board1[pos_l].setOwner (name1); 
    p1money = p1money - board1[pos_l].getPrice(); 
    println("you have bought it! you now have " +p1money + ". player 2 press 'a' to roll the die.");
    numClicks=0;
  } else {
    println (board1[pos_l].getName() + " is available for $" + board1[pos_l].getPrice() + ". Press y to buy.");
    println("player 2 roll the die (a) if player 1 doesn't buy it");
    println("");
  }
}