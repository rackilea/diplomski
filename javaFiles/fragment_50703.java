public final class Events {

   /** mapping of class events to active listeners **/
   private final HashMap<Class,ArrayList> map = new HashMap<Class,ArrayList >( 10 );

   /** Add a listener to an event class **/
   public <L> void listen( Class<? extends GameEvent<L>> evtClass, L listener) {
      final ArrayList<L> listeners = listenersOf( evtClass );
      synchronized( listeners ) {
         if ( !listeners.contains( listener ) ) {
            listeners.add( listener );
         }
      }
   }

    /** Stop sending an event class to a given listener **/
    public <L> void mute( Class<? extends GameEvent<L>> evtClass, L listener) {
      final ArrayList<L> listeners = listenersOf( evtClass );
      synchronized( listeners ) {
         listeners.remove( listener );
      }
   }

   /** Gets listeners for a given event class **/
   private <L> ArrayList<L> listenersOf(Class<? extends GameEvent<L>> evtClass) {
      synchronized ( map ) {
         @SuppressWarnings("unchecked")
         final ArrayList<L> existing = map.get( evtClass );
         if (existing != null) {
            return existing;
         }

         final ArrayList<L> emptyList = new ArrayList<L>(5);
         map.put(evtClass, emptyList);
         return emptyList;
      }
   }


   /** Notify a new event to registered listeners of this event class **/
   public <L> void notify( final GameEvent<L> evt) {
      @SuppressWarnings("unchecked")
      Class<GameEvent<L>> evtClass = (Class<GameEvent<L>>) evt.getClass();

      for ( L listener : listenersOf(  evtClass ) ) {
         evt.notify(listener);
      }
   }

}