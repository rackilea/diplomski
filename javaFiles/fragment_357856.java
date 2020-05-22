public void run() {
    while(true) {
        // Update the Game
        if(gameManager.isUsersTurn()) {
            // Collect User Input
            // Process User Input
            // Update User's State
        }
        else {
            // Update the active NPC based on their current state
            gameManager.updateCurrentNPC();
        }

        // Do your drawing
    }
}