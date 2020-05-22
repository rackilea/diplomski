class MyCallback extends Snackbar.Callback {
      Runnable run;
      @Override
      public void onDismissed(...) {
           // Do something
           if (run) run.run();
      }
}
BaseCallback<Snackbar> callback = new MyCallback();
snackbar.addCallback(callback);