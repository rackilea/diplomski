if (e.getSource() == rollDice){
    dr.roll(die1);
    dr.roll(die2);
    diceLabel.updateUI();
    dicePanel.updateUI();
}