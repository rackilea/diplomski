public void init() {
        ViewCamera axPanel = new ViewCamera(rootPane);
        axPanel.setOpaque(true);
        new Thread(axPanel).start();
        getContentPane().add(axPanel);

        // Execute a job on the event-dispatching thread; creating this applet's
        // GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {

                    createGUI();

                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }