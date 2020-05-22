public class ColorChanger {

    private Colorable colorable;

    public ColorChanger(Colorable colorable) {
        this.colorable = colorable;
    }

    public void start() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 0; index < 1000; index++) {
                    if (index % 100 == 0) {
                        if ((index / 100) % 2 == 0) {
                            colorable.setColor(Color.GREEN);
                        } else {
                            colorable.setColor(Color.RED);
                        }
                    }
                    try {
                        // This is so you can see the colors changing
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.println("Done");
            }
        });
        t.start();
    }

}