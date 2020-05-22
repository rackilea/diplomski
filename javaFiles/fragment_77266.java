// Set up h/w and backing data
int w = 300;
int h = 200;
byte[] data = new byte[w * h];

// Create a smooth gradient
for (int y = 0; y < h; y++) {
    int off = y * w;

    for (int x = 0; x < w; x++) {
        data[off + x] = (byte) (Math.round((x / (double) w) * 127) 
                              + Math.round((y / (double) h) * 127));
    }
}

// Create BufferedImage from data
final BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
image.getRaster().setDataElements(0, 0, w, h, data);

// Show it all in a window
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        JFrame frame = new JFrame(getClass().getSimpleName());
        frame.add(new JLabel(new ImageIcon(image)));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
});