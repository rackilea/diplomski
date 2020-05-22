public class Calculator {
    int x;
    int y;
    public void setNumbers(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int addNumbers(){
        return x + y;
    }

    public int multiplyNumbers(){
        return x * y;
    }
}