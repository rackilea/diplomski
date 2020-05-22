SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            textOut.setText("" + i++);
        }
    });