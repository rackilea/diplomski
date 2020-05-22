public static enum A { 
    X, Y, Z;
    private static A[] vals = values();
    public A next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }