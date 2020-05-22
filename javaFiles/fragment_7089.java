JDesktopPane background = new JDesktopPane();
    JInternalFrame internalFrame = new JInternalFrame("Internal Frame",
            true, true, true, true);
    DesktopManager manager = new DefaultDesktopManager() {
        /** This moves the <code>JComponent</code> and repaints the damaged areas. */
        @Override
        public void setBoundsForFrame(JComponent f, int newX, int newY, int newWidth, int newHeight) {
            boolean didResize = (f.getWidth() != newWidth || f.getHeight() != newHeight);
            if (!inBounds((JInternalFrame) f, newX, newY, newWidth, newHeight)) return;
            f.setBounds(newX, newY, newWidth, newHeight);
            if(didResize) {
                f.validate();
            } 
        }

        protected boolean inBounds(JInternalFrame f, int newX, int newY, int newWidth, int newHeight) {
            if (newX < 0 || newY < 0) return false;
            if (newX + newWidth > f.getDesktopPane().getWidth()) return false;
            if (newY + newHeight > f.getDesktopPane().getHeight()) return false;
            return true;
        }

    };
    background.setDesktopManager(manager);