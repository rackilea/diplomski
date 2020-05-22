// create a Player object
Player player = new Player(playerName);

// create a JProgressBar to show the health
final JProgressBar progressBar = new JProgressBar(Player.HEALTH_MIN, Player.HEALTH_MAX);
progressBar.setStringPainted(true);
progressBar.setValue(player.getHealth()); // set initial value

// add a PropertyChangeListener to Player to be notified when HEALTH changes
player.addPropertyChangeListener(Player.HEALTH, pcEvent -> setProgress(progressBar, player));