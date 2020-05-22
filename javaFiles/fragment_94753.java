public void tryToMoveTo(direction Direction) {
    if(this.canMoveTo(direction)) 
      area.update(direction); //I tell to update, not ask for coordinates that would make the player responsible for data that doesn't concern it at all.
    else
      throw new InvalidPlayerMove();  
}