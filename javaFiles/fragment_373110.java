// The actionPerformed method of the button that
// starts the maze solving computation
@Override
void actionPerformed(ActionEvent e)
{
    Thread thread = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            generateMaze();  
        }
    });
    thread.start();
}