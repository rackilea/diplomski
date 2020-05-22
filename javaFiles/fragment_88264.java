class MoveCommand implements ICommand{//parameter to store current board state
  public MoveCommand(){
    // new board state is validated
  }
  public void execute(){
    // change the board state
  }
 public void undo(){ // restore
 }
 public void redo(){ // apply again if possible
 }
}