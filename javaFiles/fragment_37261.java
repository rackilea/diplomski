class Columns<T>
{
    public static final Columns<String> RANK = new Columns<String>(0, "Rank", String.class);
    public static final Columns<Integer> NUMBER = new Columns<Integer>(1, "Number", Integer.class);

    public final Class<T> type;
    public final String text; 
    public final int index; 

    private Columns(int idx, String text, Class<T> clasz) 
    { 
        this.type = clasz; 
        this.text = text; 
        this.index = idx; 
    } 
}