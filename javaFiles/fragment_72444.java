protected class ButtonHandler implements ActionListener 
{

    @Override
    public void actionPerformed(ActionEvent event)
    {
        new Thread() {
            @Override
            public final void run() {
                startGame();
            }
        }.start();
    }
}