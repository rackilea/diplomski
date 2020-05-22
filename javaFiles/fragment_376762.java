private final AtomicInteger state = new AtomicInteger(0);
       JPanel trackPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.setColor(new Color(0, 127, 127, 255));
            g.drawRect(0, 0, getWidth()-1, getHeight()-1);
            g.setColor(new Color(0, 127, 127, 223));
            g.drawRect(1, 1, getWidth()-3, getHeight()-3);
            g.setColor(new Color(0, 127, 127, 191));
            g.drawRect(2, 2, getWidth()-5, getHeight()-5);
            g.setColor(new Color(0, 127, 127, 159));
            g.fillRect(3, 3, getWidth()-6, getHeight()-6);

            g.drawImage(BootAssets.VTScaledLogo, 0, 0, getWidth(), getHeight(), null);

            if (state.get() == 1) g.setColor(new Color(255, 255, 255, 127));
            if (state.get() == 2) g.setColor(new Color(0, 0, 0, 127));
            if (state.get() != 0) g.fillRect(0, 0, getWidth(), getHeight());                
        }
    };

    trackPanel.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            if (dragMe == null) {
                state.set(1);
            }
        }
        public void mouseExited(MouseEvent e) {
            if (dragMe == null) state.set(0);
            else state.set(1);
        }
        public void mousePressed(MouseEvent e) {
            if (dragMe == null && !e.isMetaDown())
            {
                dragMe = new DragFrameThread(vTrack);
                dragMe.start();
            }
            state.set(2);
        }
        public void mouseReleased(MouseEvent e) {
            if (state.get() == 2 && e.isMetaDown()) System.exit(0);
            if (dragMe != null) {
                dragMe.interrupt();
                dragMe = null;
                state.set(1);
            }
        }
    });