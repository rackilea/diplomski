private volatile size;

public synchronized void take(){
      while(size<500){
        ........
        .........
      }
}