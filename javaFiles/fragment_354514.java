while(true){
        // the robot gets assigned a new position based on a communication
        // protocoll used by the Robots which I have removed for convenience

        Platform.runLater(() -> {

            Random r = new Random();
            double nextX = 0 + (100) * r.nextDouble();
            double nextY = 0 + (100) * r.nextDouble();
            this.move(nextX, nextY);

        });

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}