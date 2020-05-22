volatile List<Player> players = ...; // load your list of Player
volatile int currentPlayerIndex = 0;
volatile Player currentPlayer = null;
private final Object WAIT_MONITOR = new Object(); // yes, 'new Object()' !
[...]
public void run() throws InterruptedException {
    playerLoop:
    while(programRunning) { // maybe while(true)
        synchronized (WAIT_MONITOR) {
            loadPlayer(currentPlayer);
            loadItems(currentPlayer);

            updateItems(currentPlayer);
            WAIT_MONITOR.wait(1000);
        }
    }
}

[...]

JButton jbNext = new JButton("Next Player");       

jbNext.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized(WAIT_MONITOR) { // this causes that the contents of run() and this method do not run at the same time.
            currentPlayer.setCurrentTurn(false);
            if(players.size() > currentPlayerIndex + 1) // don't use >=
                currentPlayerIndex++;
            else
                currentPlayerIndex = 0; // reset at the end of the list
            currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.setCurrentTurn(true);
            WAIT_MONITOR.notifyAll(); // that causes the wait() method above to be continued.
        }
    }
});