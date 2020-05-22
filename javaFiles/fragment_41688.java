private AtomicBoolean secondMethodIsDone = new AtomicBoolean(false);

void firstMethod() {
   methodInOtherThread();
   while(!secondMethodIsDone.get()) {
        //thread sleep waiting...
   }
   // do your things when second is done     
}