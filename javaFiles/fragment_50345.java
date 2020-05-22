synchronized (this.requests) {
     // Add request to queue
     this.requests.add(key);
     // Notify the Worker thread that there's work to do
     this.requests.notifyAll();
   }

   // ----- MOMENT1.  If at this moment Worker puts result into cache it
   // will be missed since notification will be lost

   synchronized (this.cache) {
     // Wait until Worker has updated the cache
     this.cache.wait();

    // ----- MOMENT2.  May be too late, since cache notifiation happened before at MOMENT1

    // Now, cache should contain a value for key
     return this.cache.get(key);
   }