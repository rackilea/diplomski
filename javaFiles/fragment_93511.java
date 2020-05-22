public class ImageLoadShowAndWait extends SwingWorker<Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
        BufferedImage img = ImageIO.read(...);
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                ImageShower.show(null, img);
            }
        });
        return null;
    }

}