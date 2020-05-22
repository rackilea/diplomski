enum States {
    IDLE, NEAREST, NEARESTTOHQ,NORTH,SOUTH,EAST,WEST,IDLESPAWN
}

public enum Modules {
    ATTACK(IDLE, NEAREST, NEARESTTOHQ),
    MOVE(IDLE, NORTH, SOUTH, EAST, WEST),
    SPAWN(IDLE, SIMPLESPAWN);

    private States[] states;

    public Modules(States... states) {
        this.states=states;
    }
}