public void playSequence() {
        System.out.println("Sequence Size: " + sequence.size() + ", Spot: " + spot);
        spot = 0;
        cbutton = (Button) sequenceb.get(sequence.get(spot));

        LightRunnable lRun = new LightRunnable(10);
        Thread lt = new Thread(lRun);
        lt.start();

        toggleButtons(true);
    }

public class DarkRunnable implements Runnable {
    private int var;

    public DarkRunnable(int var) {
        this.var = var;
    }

    @Override
    public void run() {
        try {
            ++spot;
            Thread.sleep(250);
            cbutton.setAlpha((float) 0.35);
            System.out.println("Darkening Tile: " + cbutton.getTag());
            Thread.sleep(10);
            fixAlphas((float) 0.35);
            if(spot < sequence.size()) {
                cbutton = (Button) sequenceb.get(sequence.get(spot));
                LightRunnable lRun = new LightRunnable(10);
                Thread lt = new Thread(lRun);
                lt.start();
            }
        } catch(Exception e) {}
    }
}

public class LightRunnable implements Runnable {
    private int var;

    public LightRunnable(int var) {
        this.var = var;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(250);
            cbutton.setAlpha((float) 1.0);
            System.out.println("Lightening Tile: " + cbutton.getTag());
            DarkRunnable dRun = new DarkRunnable(10);
            Thread dt = new Thread(dRun);
            dt.start();
        } catch (Exception e) {}
    }
}