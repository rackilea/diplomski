Thread t = new Thread(new SomeRunnable());
 t.start();
 // do stuff
 t.join();
 // After the 'join', all memory writes made by Thread t are 
 // guaranteed to be visible to the current thread.