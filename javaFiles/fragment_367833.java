public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.runbutton) {
            running = !running;
            if (animationThread == null) {
                animationThread = new Thread(this); 
            }

            if (running) {
                dot = new CircDot(100, 100, sizebar.getValue(), Color.RED);
                animationThread.start();
            }
        } else
            ...
    }