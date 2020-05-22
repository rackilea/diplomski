package ga;

public class City {
    private int x;
    private int y;
    private int id;

    public City(int id,int x, int y){
        this.x=x;
        this.y=y;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int distance(int xOther,int yOther){
        return (int) Math.sqrt(((this.x-xOther)*(this.x-xOther))+((this.y-yOther)*(this.y-yOther)));
    }
}