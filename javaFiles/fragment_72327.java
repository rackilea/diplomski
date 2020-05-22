public class WndMain extends Window implements Observer {

    private static final long serialVersionUID = -216014257162713363L;

    private String _uuid;
    private Desktop _desktop;
    private int _notificationX;
    private MyService myService = "*Locate the service in Spring context*";


    public void onCreate(){
        super.onCreate();
        this._uuid = this.getUuid();
        this._desktop = getDesktop();
        _desktop.enableServerPush(true);
        myService.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {  
        //Check which Observable notified this Observer
        if(o instanceof MyService){
            String response = (String) arg;
            if(response.equals(_uuid)){ 
                //Enter the Desktop and fire the Notification
                Executions.schedule(_desktop, new NotificationEventListener(), new Event("onHttpResponse", this, null));
            }   
        }
    }
    private class NotificationEventListener implements EventListener<Event>{

        @Override
        public void onEvent(Event event) throws Exception {
          if(event.getName().equals("onHttpResponse")){
                Clients.showNotification("Response arrived!", Clients.NOTIFICATION_TYPE_INFO, event.getTarget(), notificationX- 200, 0, 2000);
        }
    }

    public void onClientInfo(ClientInfoEvent event){
        this._notificationX=event.getDesktopWidth()-80;
    }
}