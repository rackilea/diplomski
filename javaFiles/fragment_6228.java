final Dialog d=new Dialog((Window)null);
d.setSize(300, 300);
d.setModal(true);
new SwingWorker<Object,Object>() {
  @Override
  protected Object doInBackground() throws Exception {
    System.out.println("long running stuff");
    TimeUnit.SECONDS.sleep(10);
    System.out.println("end of long running stuff");
    return null;
  }
  @Override
  protected void done() {
    d.dispose();
  }
}.execute();
System.out.println("before setVisible(true)");
d.setVisible(true);// will block
System.out.println("after setVisible(true)");