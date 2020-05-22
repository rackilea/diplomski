try {
     SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
           guiInit();
        }
     });
  } catch (InvocationTargetException e) {
     e.getTargetException().printStackTrace(); // get the target exception
  } catch (InterruptedException e) {
     e.printStackTrace();
  }