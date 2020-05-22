@Test(timeout = 2000)
public void tickTest(){     
    long lowThreshold  = 400000000;
    long highThreshold = 600000000;

    TickCounter counter = new TickCounter();
    metronome.addObserver(counter);
    metronome.setBpm(600);

    startTime = System.nanoTime();
    metronome.run();
    long duration = System.nanoTime() - startTime;


    assertTrue(lowThreshold <= duration);
    assertTrue(duration <= highThreshold);      
}

private class TickCounter implements Observer{
    private int ticks;

    public TickCounter(){
        ticks = 0;
    }

    @Override
    public void update(Observable o, Object arg) {
        ticks++;        
        if(ticks == 5){
            metronome.stop();
        }
    }       
}