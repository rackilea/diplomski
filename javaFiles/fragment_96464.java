class CompositeListener implements OnEventListener {
   private List<OnEventListener> registeredListeners = new ArrayList<OnEventListener>();

   public void registerListener (OnEventListener listener) {
      registeredListeners.add(listener);
   }

   public void onEvent(Event e) {
      for(OnEventListener listener:registeredListeners) {
         listener.onEvent(e);
      }
   }
}