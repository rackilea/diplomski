public static void main() {  

        // Start the main game loop, note: this method will not
        // return until the game has finished running. Hence we are
        // using the actual main thread to run the game.    
        SpaceInvaders si = new SpaceInvaders();
        Thread SpaceInvaders = new Thread(si);
        SpaceInvaders.start();          
        }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        new SpaceInvaders().gameLoop();
    }
}