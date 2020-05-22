public class FinalExam {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        // define and add shapes here

        printShapes(shapes);
    }

    public static void printShapes(List<Shape> list) {
        for (Shape shape : list) {
            System.out.println(shape);
        }
    }
}