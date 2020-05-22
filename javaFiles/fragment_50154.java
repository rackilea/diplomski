btnStartLoop.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseDown(final MouseEvent e) {
        final Thread background = new Thread(new Runnable() {
            public void run()
            {
                while (true) {
                    try {
                        Display.getDefault().asyncExec(() -> text.setText("Text has been set"));
                        Thread.sleep(1000);
                    } catch (final InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        background.start();
    }
});