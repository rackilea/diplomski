Scanner sc = new Scanner(System.in);

System.out.println("Please input the size of array: ");
int arraySize = sc.nextInt(); 
sc.nextLine();//consume line separator to let `nextLine` read actuall next line
double[] myArray = new double[arraySize]; 

System.out.print("Please input " + arraySize
        + " double numbers in one line: ");
String line = sc.nextLine();
System.out.println("your numbers are "+line);

Scanner lineScanner = new Scanner(line);         
int j = 0;
while (lineScanner.hasNextDouble()) {
    myArray[j++] = lineScanner.nextDouble(); 
}
lineScanner.close();