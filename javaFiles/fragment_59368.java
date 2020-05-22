public class MyWindow {
    Integer numTimersRunning = 0;
    ...
    {
            // timer started here
            numTimersRunning++;
            //timer does its thing and makes the progress bars go up.
            ...
            //timer finishes
            numTimersRunning--;
    }

    void keyPressed(MouseEvent e) {
     if(numTimersRunning > 0) 
              return;
     // do your keyboard input processing....
    }
}