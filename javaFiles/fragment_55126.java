List<Thread> threads = new ArrayList<Thread>();
for(int i=0;i<n;i++){
    Thread t=new Thread();
    t.start();
    threads.add(t);
}

for(Thread t: threads) t.join();