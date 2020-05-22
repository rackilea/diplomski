synchronized(Lock1) {
   // do some work
  synchronized(Lock2) {
     // do some other work and commit (make changes visible)
  }
}