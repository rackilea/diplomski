public final class CloseOnLastWindowListener extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("\tCLOSING!!!");

        int nRelevant = 0;
        for (Window w : Window.getWindows()) {
            // get only visible windows, except the one being closed
            if (w != e.getWindow() && w.isVisible()) {
                System.out.println("\tRELEVANT: " + w);
                ++nRelevant;
            } else {
                System.out.println("\tirrelevant: " + w);
            }
        }

        if (nRelevant == 0) {
            System.out.println("\tEXIT!!!");
            System.exit(0);
        }
    }
}