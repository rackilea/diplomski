public class Foo {
    public char canvas[][];

    public static void main(String[] args) {
        Foo fooObj = new Foo(); //creates an instance of this class
        fooObj.createCanvas(2, 2);
        fooObj.modifyCanvas(0, 0, 'c');
    }

    public void createCanvas(int x, int y) {
        canvas = new char[x][y];
    }
    public void modifyCanvas(int x, int y, char c) {
        canvas[x][y] = c;
    }
}