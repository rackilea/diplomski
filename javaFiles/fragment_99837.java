public void actionPerformed(ActionEvent e) {
    if (e.getSource() == restartBtn) {
        restart();
    }
  }

public void restart(){
    stop(); // if necessary
    setup(); // set everything to initial state
    start(); // start game
}

public void stop(){
    // stop any timers, threads, operations etc.
}

public void setup(){
    // set to initial state.
    // something like recreate the deck, 
    // clear hands and table, shuffle, and deal.
}

public void start(){
    // code to initiate the game.
}