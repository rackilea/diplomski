Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
Set<Thread> threads = map.keySet();//Get the keys of the map, in this case the key is the thread
for(Thread thread : threads){//iterate over all the threads
    if(thread instanceof CustomThread){//check to see if it is one of our custom threads
        CustomThread custom = (CustomThread)thread;//cast it to a custom thread
        custom.printDetails();//call your method
    }
}