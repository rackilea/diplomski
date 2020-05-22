public class ServerPool {
    Random someRandGen = new Random();
    TreeMap<Integer, ServerDetails> pool;
    int totalWeight;

    public void init(ArrayList<ServerDetails> servers) {
        this.pool = new TreeMap<Integer, ServerDetails>();
        // create the "weighted selection" list
        totalWeight = 0;
        for(ServerDetails s : servers) {
            //  associate each server with the sum of the weights so far
            totalWeight += s.getWeight();
            this.pool.put(totalWeight, s);
        }
    }

    public ServerDetails getNext() {
        int rnd = someRandGen.nextInt(this.totalWeight);
        return pool.ceilingEntry(rnd).getValue();
    }
}