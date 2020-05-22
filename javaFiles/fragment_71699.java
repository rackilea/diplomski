/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    // TODO code application logic here 
    Scanner scan = new Scanner(System.in);

    int i = 0; 
    int sum = 0;
    int input;
    int inputCount = 0;

    while (i < 10){
        //Having this inside the while loop prompts the user every time.  
        System.out.println("New number?");
        input = scan.nextInt();
        inputCount++;

        if(input % 2 == 1){
            sum += input;
            i++;
        }
    }

    System.out.println("sum: "+sum);
    System.out.println("Number of odds:" + i);
    System.out.println("Numbe of inputs: " +inputCount);
    System.out.println("Average cos I miss typing sout tab:" + (inputCount/sum));
}