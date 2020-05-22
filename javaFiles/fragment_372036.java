public final static int INTERVAL = 1000;

timer = new Timer(INTERVAL, new ActionListener() {
public void actionPerformed(ActionEvent evt) {

   //Refresh the panel
       panel.revalidate();

       if (/* condition to terminate the thread. */) {
        timer.stop();
       }
    }    
});

timer.start();