frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {      
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {

                // shutdown steps go here and can update the JLabel text

                frame.dispose();
                return null;
            }
        };
        worker.execute();
    }
});