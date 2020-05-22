public class ColorChangerWorker extends SwingWorker<Void, Color> {

    private Colorable colorable;

    public ColorChangerWorker(Colorable colorable) {
        this.colorable = colorable;
    }

    @Override
    protected void process(List<Color> chunks) {
        colorable.setColor(chunks.get(chunks.size() - 1));
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int index = 0; index < 1000; index++) {
            if (index % 100 == 0) {
                if ((index / 100) % 2 == 0) {
                    publish(Color.GREEN);
                } else {
                    publish(Color.RED);
                }
            }
            try {
                // This is so you can see the colors changing
                Thread.sleep(5);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Done");
        return null;
    }

}