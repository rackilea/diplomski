game.start();
        while(game.isRunning()) {
            game.update();
            game.repaint();
        }
    }
}

class Game extends Canvas {
    private boolean running = true;
    private Ball ball = new Ball(0, 0, 50, 50);

    public void start() {   
        running = true;
    }

    public void stop() {
        //clean-up
        running = false;
    }

    public void update() { //update game logic
        ball.update();
    }

    @Override
    public void paint(Graphics g) { //render game
        super.paint(g); //clears previous graphics

        ball.render(g); //passes graphics down to entity
    }
}