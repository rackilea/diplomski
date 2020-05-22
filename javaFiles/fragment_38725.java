public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter three points for a triangle:");

        //Store the values in an array.
        double[] xCoordinates = new double[3];
        double[] yCoordinates = new double[3];
        double[] sides = new double[3];

//      Input the values into the array
        xCoordinates[0] = input.nextDouble();
        yCoordinates[0] = input.nextDouble();
        xCoordinates[1] = input.nextDouble();
        yCoordinates[1] = input.nextDouble();
        xCoordinates[2] = input.nextDouble();
        yCoordinates[2] = input.nextDouble();

//      Find the side length from the input. There probably are better ways to do this.
        sides[0] = Math.sqrt(Math.pow(xCoordinates[0]-xCoordinates[1], 2)+Math.pow(yCoordinates[0]-yCoordinates[1], 2));
        sides[1] = Math.sqrt(Math.pow(xCoordinates[1]-xCoordinates[2], 2)+Math.pow(yCoordinates[1]-yCoordinates[2], 2));
        sides[2] = Math.sqrt(Math.pow(xCoordinates[2]-xCoordinates[0], 2)+Math.pow(yCoordinates[2]-yCoordinates[0], 2));

//      Find s from the sides
        double s = ( sides[0]+sides[1]+sides[2] )/2;

//      Find the area.
        double area = Math.sqrt(s*( s-sides[0] )*( s-sides[1] )*( s-sides[2] ));

//      Print the area
        System.out.println("The area of the triangle is "+area);

//      Output~~~~~~~~~~~~~~~
//Enter three points for a triangle:
//      1.5
//      -3.4
//      4.6
//      5
//      9.5
//      -3.4
//      The area of the triangle is 33.600000000000016
}'