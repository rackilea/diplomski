Function<Integer, Double> tariff = t -> {
    if(t==500) {
        return (double)t*t;
    } else {
        return (double)t+t;
    }
};