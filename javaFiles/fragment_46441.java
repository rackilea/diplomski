private void rollDice() {
    Random random = new Random();
    int randomInt = random.nextInt(6) + 1;
    String resource = String.format("/Dice/die-%d.png", randomInt);
    Icon icon = new ImageIcon(LabGuiDice.class.getResource(resource));
    diceIconLabel.setIcon(icon);
}