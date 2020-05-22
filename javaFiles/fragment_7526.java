Thread t = new Thread(new Runnable() {
  public void run() {
    while (true) {
      try {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            b.setVisible(!b.isVisible());
          }
        });
      } catch (Exception e1) { /* Handle exception */ }

      try  {
        Thread.sleep(100);
      } catch (InterruptedException e) { /* Handle exception */ }
    }
  }
});

t.start();