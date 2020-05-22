class Resource {
    public void deplete(int amount) {
         this.amount -= amount;
         if (this.amount <= 0)
             eventDispatcher.notify(this, Events.RESOURCE_DEPLETION_EVENT);
    }
 }