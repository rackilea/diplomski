final Runnable appendTextRunnable = 
      () -> {
         for (int i = 0; i < 10000; i++) {
            staticTextArea.appendText("dada \n");
         }
      };

Platform.runLater(appendTextRunnable);