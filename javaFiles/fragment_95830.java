ij.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(final WindowEvent e) {
        // dispose all image windows
        for (final int id : WindowManager.getIDList()) {
            final ImagePlus imp = WindowManager.getImage(id);
            if (imp == null) continue;
            final ImageWindow win = imp.getWindow();
            if (win != null) win.dispose();
        }
        // dispose all other ImageJ windows
        for (final Window w : WindowManager.getAllNonImageWindows()) {
            w.dispose();
        }
    }
});