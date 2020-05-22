btnStartLoop.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseDown(final MouseEvent e) {
        final Runnable update = new Runnable() {
          public void run()
          {
            text.setText("Text has been set");

            Display.getDefault().timerExec(1000, this);
          }
        };
        Display.getDefault().timerExec(0, update);
    }
});