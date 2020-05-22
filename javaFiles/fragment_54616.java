public void run() {
      for (Control control : testShell.getChildren()) {
        control.dispose();
      }
      for (int i = 1; i < 20; i++) {
        Label label = new Label(testShell, SWT.BORDER);
        label.setText("HELLO"+i);
        label.pack();
      }
      testShell.layout(true);
    }