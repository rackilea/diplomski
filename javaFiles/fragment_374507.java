import java.util.ArrayList;

class ImageMaker
{
    static ArrayList<Shape> shapes = new ArrayList<Shape>();//all the shapes contained in the image

    public static void main(String args[])
    {
        shapes.add(new Shape());
        shapes.add(new Rect());
    }

    public static class Shape {
        System.out.print("Created new Shape");
    }

    public static class Rect extends Shape {
        //rect instance variables
        public Rect(){
            super();
            System.out.print("You've made a rect within shape");
        }
    }
}