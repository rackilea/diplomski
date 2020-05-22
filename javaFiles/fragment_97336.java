public Listener(EventType eventType) {
       this.eventType = eventType;
   }

   public void fireEvent(EventType eventType) {
       if(this.eventType == eventType) {
          ...do stuff
       }
   }