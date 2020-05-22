class ProcessorCordm extends Thread {
    int runningtime;
    public ProcessorCordm(int runningtime) {
        this.runningtime = runningtime;
    }
    public void run() {
        int loop = 1;
        long StartTime = System.currentTimeMillis() / 1000;
        for (int i = 0; i < loop; ++i) {
            int rdmCross2 = (int) (Math.random() * allPopulation.size()); // Crossover 1st vector
            int rdmCross1 = (int) (Math.random() * allPopulation.size());
            Vector muted = new Vector();
            Vector copy = copi((Vector) allPopulation.get(rdmCross2));
            Vector callp = copi((Vector) allPopulation.get(rdmCross1));
            muted = crossover(callp, copy);
            System.out.println("cross over Between two Randoms ----------->");
            affiche_resultat(muted);
            addsolution(muted);
            loop++;
            if (timevalue < ((System.currentTimeMillis() / 1000) - StartTime)) {
                loop = 0;
            }
        }
    }
}