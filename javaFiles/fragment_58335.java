// GUI

    frame.validate();
    //frame.repaint();

    frame.pack();
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            frame.setVisible(true);
        }
    });