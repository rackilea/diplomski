static final Map<Integer, Double> cases = new HashMap<Integer, Double>(9);

static{             
    cases.put(1, 30.0);
    cases.put(2, 55.0);     
    cases.put(3, 70.0);     
    cases.put(4, 80.0);     
    cases.put(5, 84.0);     
    cases.put(6, 88.0);     
    cases.put(7, 92.0);     
    cases.put(8, 96.0);     
    cases.put(9, 100.0);
}

switch (getIntFromDouble(Math.random()*100)) {
    case 0 : ...
        break;

    case 1 : ...
        break;

    ...     

    case 9 : ...
        break;

}

private int getIntFromDouble(double rand){

    for(Map.Entry<Integer, Double> entry : cases.entrySet()){
        if(rand <= entry.getValue())
            return entry.getKey();
    }

    return Integer.MAX_VALUE;
}