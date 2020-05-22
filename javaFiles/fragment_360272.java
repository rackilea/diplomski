public static String print() 
{
    getPerimeter(length,width);
    getArea(length,width);
    String Rectangle = new String();
    System.out.println("This rectangle has a length of "+length+" and a width of "+width);
    System.out.println("The area of the rectangle is: "+ area);
    System.out.println("The perimeter of the rectangle is: "+ perimeter);
    return Rectangle;

}