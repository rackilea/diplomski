public class ImageLoadAndShow extends SwingWorker<Void, Image> {

    @Override
    protected Void doInBackground() throws Exception {
        BufferedImage img = ImageIO.read(...);
        publish(img);
        return null;
    }

    @Override
    protected void process(List<Image> chunks) {
        Image img = chunks.get(chunks.size() - 1);
        ImageShower.show(null, img);
    }

}