public class MyUserInputClass {

    public static void main(String[] args)
    {
        // USER INPUT
        String rad;
        Scanner ss = new Scanner(System.in);
        System.out.print("Input radius: ");
        rad = ss.nextLine();
        Cercle myCercle = new Cercle(rad);

        // That's it, that's all you have to do, 
        // you now have a circle and you can get its area and perimeter

        System.out.println("Cercle: "+rad);
        System.out.println("PI       : "+myCercle.getPI());
        System.out.println("Radius   : "+myCercle.getRadius());
        System.out.println("Area     : "+myCercle.computeArea());
        System.out.println("Perimeter: "+myCercle.computePerimeter());
    }
}