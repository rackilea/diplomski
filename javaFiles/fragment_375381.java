/* Import the necessary Applet entry-point */
import ssfd.SteadyStateFusionDemo;

/* Subclass SSFD to override "problematic" methods */
SteadyStateFusionDemo ssfd = new SteadyStateFusionDemo() {
    @Override
    public URL getCodeBase() {
        /* We don't care about the code-base any more */
        return null;
    }

    @Override
    public Image getImage(URL codeBase, String imgPath) {
        /* Load and return the specified image */
        return Toolkit.getDefaultToolkit().getImage(
                this.getClass().getResource("/" + imgPath));
    }
};
ssfd.init();

/* Create a JFrame and set the Applet as its ContentPane */
JFrame frame = new JFrame();
frame.setContentPane(ssfd);

/* Configure and show the JFrame */
...