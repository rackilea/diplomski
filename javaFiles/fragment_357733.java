enum Style1{
    FIRE_BALL(false),
    ICE_BALL(true),
    FIRE_ARROW(false),
    ICE_ARROW(true);

    private final cold;

    private Style1(boolean cold){
        this.cold = cold;
    }

    public boolean isCold(){
        return cold;
    }
}