public static double deviation(File inputFile){
    double number = 0;
    double n = 0;
    double sum = 0;
    double sum1 = 0;
    int count = 0;
    double mean = 0;

    Scanner reader = new Scanner(inputFile);
    while(reader.hasNext()){
        number = reader.nextDouble();
        sum = sum + number;
        sum1 = sum1 + Math.pow(number,2);
        n++;
    }

    double n1 = Math.sqrt(n);
    double sum11 = Math.sqrt(sum1);
    mean = sum / n;

    double n12 = Math.pow(n,2) - n;
    double n22 = Math.pow(sum, 2);
    double x = ( n * sum1 - n22) / (n12);
    return Math.sqrt(x);
}
public static void main(String[] args) throws FileNotFoundException {
    Scanner Scanscan = new Scanner(System.in);
    System.out.print("Enter the name of the file: ");
    String filename = Scanscan.nextLine();
    File inputFile = new File(filename);
    double deviation = deviation(inputFile);
    System.out.println( "The standard deviation of the values in this file is: " + deviation);
}