masterWindow.addComponentListener(new ComponentAdapter() {
      private int oldWidth = 0;
      private int oldHeight = 0;

      @Override
      public void componentResized(ComponentEvent e) {
        oldWidth = masterWindow.getWidth();
        oldHeight = masterWindow.getHeight();
      }

      @Override
      public void componentMoved(ComponentEvent e) {
          if (masterWindow.getWidth() != oldWidth || masterWindow.getHeight() != oldHeight) {
            masterWindow.invalidate();
            masterWindow.validate();
          }
          oldWidth = masterWindow.getWidth();
          oldHeight = masterWindow.getHeight();
      }
    });