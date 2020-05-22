ThreadGroup g=new ThreadGroup("client X group");

Runnable r=new Runnable(){
public void run(){
  client.doSmth();//assuming a new thread is started...
}
}
Thread t= new Thread(g, r, "clientStarter");
t.start();

 //stopping, last resort code, it's usually more complicated than just thread.stop, though

//now you can enumerate threads of the ThreadGroup
synchronized(g){//sync ensures no more threads will be created, use it w/ extreme caution
  Thread[] threads = new Thread[g.activeCount()];
  for(Thread thread:threads){
    if(thread==null) break;
    thread.stop();//
  //cannot join in sync of ThreadGroup, do not use it here
    }
  }