public enum AiMove {
    NONE      (),
    UP        (0),
    DOWN      (1),
    LEFT      (2),
    RIGHT     (3),
    TURN_Q    (4),
    TURN_E    (5),
    MOUSE_1   (6),
    MOUSE_2   (7),
    STOP      (8),
    MOUSE_1_2 (MOUSE_1, MOUSE_2),
    UP_LEFT   (UP, LEFT),
    DOWN_LEFT (DOWN, LEFT),
    ... // some 108(?) combinations listed here.... ;

    private final BitSet bitsUDLRQE12S = new BitSet(9);

    AiMove(int index) {
        bitsUDLRQE12S.set(index);
    }

    AiMove(AiMove... moves) {
        for (AiMove move : moves) {
            bitsUDLRQE12S.or(move.getBitSet());
        }
    }

    private BitSet getBitSet() { return bitsUDLRQE12S; }

    public boolean hasUp() { return bitsUDLRQE12S.get(0); }
    public boolean hasDown() { return bitsUDLRQE12S.get(1); }
    public boolean hasLeft() { return bitsUDLRQE12S.get(2); }
    public boolean hasRight() { return bitsUDLRQE12S.get(3); }
    public boolean hasTurnQ() { return bitsUDLRQE12S.get(4); }
    public boolean hasTurnE() { return bitsUDLRQE12S.get(5); }
    public boolean hasMouse1() { return bitsUDLRQE12S.get(6); }
    public boolean hasMouse2() { return bitsUDLRQE12S.get(7); }
    public boolean isStopped() { return bitsUDLRQE12S.get(8); }
}