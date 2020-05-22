class Rectangle{
    private int width;
    private int height;
    public Rectangle(int a, int b){
        this.width=a; this.height=b
    }
    public Rectangle(int c){
       this(c, c);
    }
    public int getArea(){
        return width*height;
    }
}
class session1{
   // two ways of using it
    public static void main(String args[]){
        System.out.println("The area of rectangle is: "+new Rectangle(20,10).getArea();
        Rectangle obj = new Rectangle(10);
        System.out.println("The area of square is: "+obj.getArea());
    }
}