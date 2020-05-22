class DataStoreTipo0 implements Iterable<ItemToUpdateTipo0> {
   private Queue<ItemToUpdateTipo0> queueItemToUpdateTipo0 = new ConcurrentLinkedQueue<ItemToUpdateTipo0>();

   @Override
   public Iterator<ItemToUpdateTipo0> iterator() {
      return queueItemToUpdateTipo0.iterator();
   }
}