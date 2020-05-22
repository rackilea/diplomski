public class Pair{
    int x,y;

    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return ((x + y) << 234234) % 21354205;
    }

    public boolean equals(Object o){
        if(o instanceof Pair){
            Pair p = (Pair) o;
            return p.x == x && p.y == y;
        }else{
            return false;
        }
    }
}