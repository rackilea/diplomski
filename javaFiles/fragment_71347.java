...
 if (this.getCurrentPlayer().getIsMyTurn() == this.getComputerPlayer().getIsMyTurn()) {
        this.theComputer.takeTurn();
        this.hold();
        alertHumanPlayer();
    }
...

protected void alertHumanPlayer(){
    HumanPlayerPanel.turnAlert();
}