interface Sandwich {
    String description();
    float price();
}

class BasicSandwich implements Sandwich {
    @Override
    public String description() {
        return "Sandwich";
    }    
    @Override
    public float price() {
        return 4f;
    }    
}

class CheeseSandwich implements Sandwich {   
    private final Sandwich origin;
    public CheeseSandwich(Sandwich origin) {
        this.origin = origin;
    }
    @Override
    public String description() {
        return origin.description() + " , Cheese";
    }    
    @Override
    public float price() {
        return origin.price() + 1f;
    }   
}

//More implementations of Sandwich