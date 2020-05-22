public class ScanWorker extends SwingWorker<Object, ImageProperty> {

    private File source;
    private ImageTableModel model;

    public ScanWorker(File source, ImageTableModel model) {
        this.source = source;
        this.model = model;
    }

    @Override
    protected void process(List<ImageProperty> chunks) {
        model.addImages(chunks);
    }

    @Override
    protected Object doInBackground() throws Exception {
        scan(source);
        return null;
    }

    protected void scan(File dir) {
        firePropertyChange("directory", dir.getParent(), dir);
        File pngs[] = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".png");
            }
        });
        for (File png : pngs) {
            try {
                BufferedImage img = ImageIO.read(png);
                publish(new ImageProperty(png, new Dimension(img.getWidth(), img.getHeight()), false));
            } catch (IOException e) {
                System.out.println("Bad image: " + png);
                e.printStackTrace();
            }
        }
        File dirs[] = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if (dirs != null && dirs.length > 0) {
            for (File subDir : dirs) {
                scan(subDir);
            }
        }
    }

}