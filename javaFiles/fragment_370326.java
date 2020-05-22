class Distribution<T>{
    List<Double> probs = new ArrayList<>();
    List<T> events = new ArrayList<>();
    double sumProb;
    Random rand = new Random();

    Distribution(Map<T,Double> probs){
        for(T event : probs.keySet()){
            sumProb += probs.get(event);
            events.add(event);
            this.probs.add(probs.get(event));
        }
    }

    public T sample(){
        T value;
        double prob = rand.nextDouble()*sumProb;
        int i;
        for(i=0; prob>0; i++){
            prob-= probs.get(i);
        }
        return events.get(i-1);
    }
}