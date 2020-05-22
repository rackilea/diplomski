final TimerTask tt = new TimerTask() {
        @Override
        public void run() {
            if (count < 1000) {
               //increment rectangles y position
                //now repaint container so we can see changes in co-ordinates (unless you have a timer which repaints for you too)
            count++;
            } else {//counter is at 1000 stop the timer
                cancel();
            }
        }
    };

    new Timer().scheduleAtFixedRate(tt, 0, 10);//start in 0milis and call run every 10 milis