System.out.println("Write a list of integers and type 0 when you are finished");
Scanner kb=new Scanner(System.in);
int input=kb.nextInt();
int smallestValue=Integer.MAX_VALUE; 

while(input!=0){//loop until user inputs 0
    if(input>0) {//check for inputs greater than 0 and ignore -ve values
        if(input<smallestValue) // save the smallest value
            smallestValue = input;
    }
    input=kb.nextInt();
}
System.out.println(smallestValue+">0");