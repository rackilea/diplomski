SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            label.setText(s);
        }
    });