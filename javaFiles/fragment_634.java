final String path = "/example.png";
new SwingWorker<BufferedImage, Void>() {
    @Override
    public BufferedImage doInBackground() throws IOException {
        return ImageIO.read(ClassName.class.getResource(path));
    }
    @Override
    public void done() {
        try {
            BufferedImage img = get();
            // put img somewhere
        } catch(InterruptedException ignored) {
        } catch(ExecutionException ex) {
            ex.printStackTrace(System.err);
        }
    }
}.execute();