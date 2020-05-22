public void init() {
    // Bad idea: the applet is not initialized yet
    // but you already use link to its instance.
    //final JApplet myApplet = this; 

    try {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                JPanel frame = new PokerFrame();
                //frame.setVisible(true); // You don't need this.
                // You don't need myApplet variable 
                // to call getContentPane() method.
                //myApplet.getContentPane().add(frame);
                getContentPane().add(frame);
            }
        });
    } catch (Exception e) {
        System.err.println("createGUI didn't complete successfully");
    }
}