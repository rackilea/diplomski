public BestServer(RTT best) throws InterruptedException{
    bestserver = best;
    findBest();
}

public static void findBest() throws InterruptedException{
    Thread t = new Thread(new BestServer(bestserver));
}