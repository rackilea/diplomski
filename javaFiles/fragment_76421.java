public enum AiMove {
    //         u/d    l/r    q/e    m1     m2     stop
    STOP      (null,  null,  null,  false, false, true),
    NONE      (null,  null,  null,  false, false, false),
    UP        (true,  null,  null,  false, false, false),
    DOWN      (false, null,  null,  false, false, false),
    LEFT      (null,  true,  null,  false, false, false),
    RIGHT     (null,  false, null,  false, false, false),
    TURN_Q    (null,  null,  true,  false, false, false),
    TURN_E    (null,  null,  false, false, false, false),
    MOUSE_1   (null,  null,  null,  true,  false, false),
    MOUSE_2   (null,  null,  null,  false, true,  false),
    MOUSE_1_2 (null,  null,  null,  true,  true,  false),
    UP_LEFT   (true,  true,  null,  false, false, false),
    DOWN_LEFT (false, true,  null,  false, false, false),
    ... // some 108(?) combinations listed here.... ;

    private final Boolean upDown;
    private final Boolean leftRight;
    private final Boolean turnQE;
    private final boolean mouse1;
    private final boolean mouse2;
    private final boolean stop;

    AiMove(Boolean upDown, Boolean leftRight, Boolean turnQE,
           boolean mouse1, boolean mouse2, boolean stop) {
        this.upDown = upDown;
        this.leftRight = leftRight;
        this.turnQE = turnQE;
        this.mouse1 = mouse1;
        this.mouse2 = mouse2;
        this.stop = stop;
    }
    public boolean isStopped() { return stop; }
    public boolean hasUp() { return Boolean.TRUE.equals(upDown); }
    public boolean hasDown() { return Boolean.FALSE.equals(upDown); }
    public boolean hasLeft() { return Boolean.TRUE.equals(leftRight); }
    public boolean hasRight() { return Boolean.FALSE.equals(leftRight); }
    public boolean hasTurnQ() { return Boolean.TRUE.equals(turnQE); }
    public boolean hasTurnE() { return Boolean.FALSE.equals(turnQE); }
    public boolean hasMouse1() { return mouse1; }
    public boolean hasMouse2() { return mouse2; }
}