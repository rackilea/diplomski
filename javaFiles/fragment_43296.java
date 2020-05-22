double length;
double width;
double boxArea;

Scanner input = new Scanner(System.in);

System.out.println("Enter the value for length and width")

length = input.nextDouble();
width = input.nextDouble();

boxArea = box(length, width);

// You can call box method inside main method with user input values of length and width.