class YourClass {

    Timer timer;

    public void startTourButton(ActionEvent event) {
        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(
            new TimerTask () {    
                public void run(){          
                    System.out.println("Going to do something here");
                }   
            }, 0, 5000);
        }
    }

    public void stopTourButton(ActionEvent event) {
        timer.cancel();
        timer = null;
    }
}