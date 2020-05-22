// listeners
   private List<LocationListener> listeners = new ArrayList<LocationListener>();
   public void addListener(LocationListener l){
      listeners.add(l);
   }
   public void removeListener(LocationListener l){
      listeners.remove(l);
   }