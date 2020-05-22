private SomeThread getSomeThread(){
    Thread thread=null;
    int i=0;

    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
    Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
    while(thread==null && i<threadArray.length){
        if(threadArray[i].getName().equals(SomeThread.class.getSimpleName()))
            thread=threadArray[i];
        i++;
    }

    return (SomeThread)thread;  
}