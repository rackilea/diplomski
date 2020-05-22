SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
           new MyWindow().setVisible(true);
        }
    });