public void actionPerformed(ActionEvent e) {
     if (roll_dice.getDelay() > 500) {
        roll_dice.setDelay(50);
        roll_dice.stop();
        movePiece(); // I like this -- this shouldn't change
     } else {
        roll_dice.setDelay(roll_dice.getDelay() + 50);
        // dice_panel.repaint(0);
        for (JLabel dieLabel : diceLabels) {
           int randomIndex = random.nextInt(diceIcons.length);
           dieLabel.setIcon(diceIcons[randomIndex]);
        }
     }
  }