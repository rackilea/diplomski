public static void printRectangleDetails(Rectangle r){

    System.out.println("Rectangle 1: " + "\n" + "Width: " + r.width + "\n" + "Height: " +
            r.height + "\n" + "Color: " + r.color + "\n" + "Area and Perimeter: " + 
                    r.getArea(r.width, r.height) + ", " + r.getPerimeter(r.width, r.height));
}