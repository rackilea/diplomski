final class Colours extends java.lang.Enum {
    public final static Colours RED = new Colours("RED", 0);
    public final static Colours BLUE = new Colours("BLUE", 1);

    private final static values = new Colours[]{ RED, BLUE };

    private Colours(String name, int sequence){
        super(name, sequence);
    }

    public static Colours[] values(){
        return values;
    }

    public static Colours valueOf(String name){
        return (Colours)java.lang.Enum.valueOf(Colours.class, name);
    }
}