private void startAnimation(final JPanel panel){
    //create a anonym class
    Runnable r = new Runnable(){
        private int py = 0; //previous values
        private int py = 0; //previous values
        @overrdie
        public void run(){
            for(int x = 0; x < endOfX ; x++){
                int y = data[x];
                //now we have x and y, so you can plot your function;
                gr.drawLine(px, py, x,y); //you can scale here
                int sleeptime = calculateSleepTime(px,py, x,y);
                Thread.sleep(sleeptime);

                //set the previouse values;
                px = x;
                py = y;

                //important - repaint your panel to create an 'animation'
                panel.repaint();

            }
        }
    }

    //having that runnable we must start that runnable within an thread
    Thread thread = new Thread(r);
    thread.setDaemon(true);
    thread.start();
}