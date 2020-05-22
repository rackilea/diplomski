public void run() {
        while (running) {
            if (!showtails) {
                dot.setColor(drawingpanel.getBackground());
            }
            update();// check if speed, size, or shape changed
            draw();// draw next dot based on move(), or initial condition
            pause();
            move();// calculate and prepare the coordinates for the next
                   // iteration to be drawn
        }
    }

    public void draw() {
        drawingpanel.repaint();
    }

    public void pause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void move() {
        dot.left--;
        dot.top--;
    }