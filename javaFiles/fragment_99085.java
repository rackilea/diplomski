public class Main {  
    public static void main(String[] args) {       
        // you only need one instance of scanner
        Scanner s = new Scanner(System.in);
        int numone = s.nextInt();
        System.out.println("please input the number of numbers you want to analyze");
        int numtwo = s.nextInt();
        // don't forget to close the scanner
        s.close();    
    }
}