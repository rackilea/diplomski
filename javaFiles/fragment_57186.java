void restoreDefaults() {
    f.setSize(f.getWidth(), getDesktopRect(f.getGraphicsConfiguration()).height);
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            sp.setDividerLocation(sp.getSize().height - 100);  

        }
    });
}