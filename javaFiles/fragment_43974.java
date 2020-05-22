this.addWindowListener(new WindowAdapter() {
    @Override
    public void windowActivated(WindowEvent we) {
        try {
            java.awt.Robot r = new java.awt.Robot();

            //first time to update the event
            r.keyPress(KeyEvent.VK_CAPS_LOCK);
            r.keyRelease(KeyEvent.VK_CAPS_LOCK);

            //second time to return to the last time status
            r.keyPress(KeyEvent.VK_CAPS_LOCK);
            r.keyRelease(KeyEvent.VK_CAPS_LOCK);

        } catch (Exception e) {}

      updateStatus();

    }
}
);