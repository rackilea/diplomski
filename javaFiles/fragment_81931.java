public class Jump implements Runnable {

    private Player player;
    private GameScene gameScene;

    public Jump (Player player, GameScene gameScene){
        this.player = player;
        this.gameScene = gameScene;
    }

    @Override
    public void run(){
        int eindHoogte = player.getPoint().y - 60;

        while (player.getPoint().y > eindHoogte) {
                player.playerMoveUp(3);
                gameScene.update();

                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

        synchronized(player){

            // acts as a signal to gravity thread to start processing the gravity operation
            player.setJumpComplete(true);
        }

    }

}


    public class Gravity implements Runnable {

        private Player player;
        private GameScene gameScene;

        public Gravity (Player player, GameScene gameScene){
            this.player = player;
            this.gameScene = gameScene;
        }

        @Override
        public void run(){



            while(true){

                synchronized (player) {

                    // if player has completed the jump then process the gravity operation else just wait for jump to complete
                    if(player.isJumpComplete()){
                        player.playerMoveDown(3);
                        gameScene.update();

                        // reset the jump flag and wait for the next jump operation to complete
                        player.setJumpComplete(false);
                    }

                }

                try {
                    Thread.sleep(25);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }