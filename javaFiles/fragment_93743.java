public void run() { 
    for (int i = 1; i <= 1000; i++) {
      synchronized(count){ 
        count.setCount(count.getCount() + 1); 
      }
    } 
}