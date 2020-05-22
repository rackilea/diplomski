// [...]
    CyclicBarrier barrier = new CyclicBarrier(parts.size() + 1); // sorting threads AND main thread
    for(int[] e:parts){
        Thread t=new Thread(new sortingThread(barrier,e,layer));
        t.start();
    }
} else 
        // [...]
//The main thread should not proceed, unless the above barrier is broken
barrier.await();
sortandkeep(toIntArray(layer));
// [...]