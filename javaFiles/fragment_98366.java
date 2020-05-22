start.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        start.setEnabled(false);
        synchronized(LOCK) {
            if(!gameIsRunning) {
                new GameThread().start();
            }
        }
   }
});