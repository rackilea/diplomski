public static final int MOVE_SPEED = 10;
public static final int DOWN = 2;
public static final int LEFT = 4;
public static final int UP = 8;
public static final int RIGHT = 6;
public static final int NO_INPUT = 0;
public static final long GAME_CLOCK = 1000L;
public static final int BODY_WIDTH = 5;
public static final int BODY_HEIGHT = 5;

... 

       while (gameIsLive) { 
        if(userInput.isDone()){
            try {
                commands = userInput.get().intValue();
            } catch (InterruptedException ex) {
              commands = NO_INPUT;
            } catch (ExecutionException ex) {
               commands = NO_INPUT;
            }
            userInput = executor.submit(new BilSpil());
        }

        switch(commands){
            case DOWN:
                y += MOVE_SPEED;
                break;
            case LEFT:
                x -= MOVE_SPEED;
                break;
            case UP:
                y -= MOVE_SPEED;
                break;
            case RIGHT:
                x += MOVE_SPEED;
                break;
        }
        cp.paintOval(x, y, BODY_WIDTH, BODY_HEIGHT);
        cp.repaintFrame();
        try{Thread.sleep(GAME_CLOCK);}
            catch (InterruptedException e) {}
    }
}