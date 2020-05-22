int delay = 3000;
    int period = 50;
    Timer timer = new Timer();

    timer.scheduleAtFixedRate(new TimerTask() {
        int spaces=0;
        public void run() {
            String title="";
            for (int j = 0; j < spaces; j++) {
                title+= " " ;
            }
            title+= "Annoying";
            Main.this.setTitle(title);
            spaces=(spaces+1)%50;
        }
    }, delay, period);