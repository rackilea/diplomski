abstract class Actions {
    abstract Actions stand();
}

class SimpleActions extends Actions {
    private static final Actions STAND = ...;

    @Override Actions stand() { return STAND;}
}