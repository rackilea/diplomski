public class LoadAppletWorker extends SwingWorker<JApplet, JApplet> {

    @Override
    protected JApplet doInBackground() throws Exception {
        // TODO add your handling code here:
        JApplet applet = new defg();

        // Send the applet an init() message.
        applet.init();

        return applet;
    }

    @Override
    protected void done() {
        try {
            JApplet applet = get();

            // Construct a JFrame.
            final JFrame frame
                    = new JFrame("FrameTitle");

            // Transfer the applet's context pane to the JFrame.
            frame.setContentPane(applet.getContentPane());

            // Transfer the applet's menu bar into the JFrame.
            // This line can be omitted if the applet
            // does not create a menu bar.
            frame.setJMenuBar(applet.getJMenuBar());

            // Make the application shut down when the user clicks
            // on the close button.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the size of the frame.
            // To pack the frame as tightly as possible
            // replace the setSize() message with the following.
            // frame.pack();
            frame.setSize(800, 800);

            // Set the location of the frame.
            frame.setLocation(30, 30);

            // Show the frame.
            frame.setVisible(true);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Initapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}