public class Main {
    public static void main(String[] args) throws Exception {

        BufferedImage original = ImageIO.read(new File("/Users/Nick/Desktop/with_flowers.jpg"));
         // 300 seems to be a good number
        final RenderedOp cqImage = ColorQuantizerDescriptor.create(
           original, ColorQuantizerDescriptor.OCTTREE,
           new Integer(255), new Integer(300), null, new Integer(2),
           new Integer(2), null);

        assert cqImage.getColorModel() instanceof IndexColorModel;
        final BufferedImage converted = cqImage.getAsBufferedImage();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame f = new JFrame();
                f.setTitle("Test");
                f.getContentPane().add((new ScrollingImagePanel(converted, 300, 300)));
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }
}