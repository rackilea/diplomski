@Override
public void doAfterCompose(Groupbox comp) throws Exception {
  super.doAfterCompose(comp);
  comp.addEventListener(Events.ON_CLIENT_INFO, new EventListener<ClientInfoEvent>() {
    @Override
    public void onEvent(ClientInfoEvent event) throws Exception {
      if (event.isLandscape()) {
        // do things when landscape
      } else {
        // do other things else.
      }
    }
  });
}