new Thread(() -> {
    for (int i = 1; true; i++) {
        try {
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            return;
        }

        if (shell.isDisposed())  // Stop thread when shell is closed
          break;

        final String newText = Integer.toString(i);
        Display.getDefault().asyncExec(() -> text.setText(newText));
    }
}).start();