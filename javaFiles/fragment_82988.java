public class Square {

    private String id;
    private int x;
    private int y;

    public Square(){};

    public Square(String id,int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    };

    public Map<String, Integer> getSquare()
    {
    Map<String, Integer> res = new HashMap<>();
    res.put("x", x);
    res.put("y", y);
    return res;
}

}