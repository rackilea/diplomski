public enum Rank {
    TEN("Ten", (byte)1),
    NINE("Nine", (byte)2),
    EIGHT("Eight", (byte)0),
    SEVEN("Seven", (byte)0);


    private final String name;
    private final byte point;

    private Rank(String name, byte point)
    {
        this.name = name;
        this.point = point;
    }