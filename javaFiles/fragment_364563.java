public void startThreads(ArrayList<ArrayList<Tocka>> pLista) {
    final Object lockOb = new Object();

    ScheduledThreadPoolExecutor eventPool = new ScheduledThreadPoolExecutor(pLista.size());
        for(int i=0; i<pLista.size(); i++) {
            eventPool.execute(new Dretva(lockOb, pLista.get(i),i));
        }
}

Object lockOb;

public void run() {
    synchronized(lockOb) {
       System.out.print(this.id + ". ");
       optimalnost.printOrder(this.lista);
       double distance = optimalnost.getDistanceList(this.lista);
       System.out.println(" - " + distance);
       System.out.println();
       checkMin(distance);
    }
}