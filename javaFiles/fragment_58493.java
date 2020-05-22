private static class MyRunnable implements Runnable {
  int i=10;     
  final ImageView im=(ImageView)findViewById(R.id.imageView1);
  public void run() {
    im.setX(i);
    im.setY(i);
    i=i+100;
  }
}

// then in onCreate
Runnable r = new MyRunnable();
exec.scheduleAtFixedRate(r, 0, 4, TimeUnit.SECONDS);