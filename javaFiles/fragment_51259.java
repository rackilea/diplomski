public class Test {

    public static void main(String args[]) {
        int width = getDimension().getLeft();
        System.out.println(width);
    }

    public static Pair<Integer, Integer> getDimension() {
        int shapeWidth = 5;
        int shapeHeight = 10;
        return new Pair<Integer, Integer>(shapeWidth, shapeHeight);
    }
}