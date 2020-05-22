class CommInt {

  private List <OnNotificationEvent> listeners= new ArrayList <OnNotificationEvent>();


  public void addNotificationListener(OnNotificationEvent notifListner) {
    listeners.add (notifListener);
  }

  private void parseMsg(Message msg) {

    if (msg.getType() == x) {
      for (notifListener : listeners){
        notifListener.updateUI();
      }
    }

  }

}