public class JLayerSample {

    private static JLayer<JComponent> createLayer() {
        // This custom layerUI will intercept all mouseMotion events generated within its borders and delegate to the wrapped JPanel
        LayerUI<JComponent> layerUI = new LayerUI<JComponent>() {

            public void installUI(JComponent c) {
                super.installUI(c);
                // enable mouse events for the layer's subcomponents
                ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
            }

            public void uninstallUI(JComponent c) {
                super.uninstallUI(c);
                // reset the layer event mask
                ((JLayer) c).setLayerEventMask(0);
            }

            // overridden method which catches MouseMotion events
            public void eventDispatched(AWTEvent e, JLayer<? extends JComponent> l) {
                if (e instanceof MouseEvent) {
                    System.out.println("MouseEvent detected " + e);
                    // Do drag gesture processing here.
                    // Note, you cannot dispatch these events to the view component, since that
                    // creates an event loop.
                }
            }
        };

        // create a component to be decorated with the layer
        // This would be your custom component.
        JPanel panel = new JPanel();
        panel.add(new JButton("JButton"));

        // create the layer for the panel using our custom layerUI
        return new JLayer<JComponent>(panel, layerUI);
    }

    private static void createAndShowGUI() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // work with the layer as with any other Swing component
        frame.add(createLayer());

        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}