Precessor []workers = new Processor[NUM_WORKER];
for(int i=0;i<NUM_WORKER; i++) {
    worker[i] = new Processor(requests);
    Thread th = new Thread(worker[i]);
    th.strat();
}