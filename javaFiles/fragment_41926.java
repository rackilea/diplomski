windowEvent.getComponent().setVisible(false);
try {
  Thread.sleep(5000);
} catch (InterruptedException e) {
  e.printStackTrace();
}
System.out.println("Showing");
windowEvent.getComponent().setVisible(true);