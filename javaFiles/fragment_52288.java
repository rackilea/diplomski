class Canvas{
     public static void main(String[] args){
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());

        // clean and neat code

        for(Shape shape : shapes){
              shape.draw();
        }

     }
 }