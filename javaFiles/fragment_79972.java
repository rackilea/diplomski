/*
 * Double click action performed *
 */
trayIcon.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Desktop dst = Desktop.getDesktop();
            dst.open(new File(location));
            /*
             * reset the location to root location again.
             */
            location = Root_Location_Here // again setting root location                    
        } catch (Exception ex) {
            logger.error("------- error with folder opening double click "
                    + ex.getMessage());
        }
    }
});