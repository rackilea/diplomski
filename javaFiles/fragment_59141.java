public class Direction extends java.lang.Enum{
    public final static Direction NORTH;
    ...

    static{
        NORTH = new Direction("NORTH", 0);
        ...

        VALUES = new Direction[(size here)];
        VALUES[0] = NORTH;
        ...
    }
} // taken from the referred blogpost