public static void main(String[] args) {
    add addobj= new add();//Use camel case naming convention for classes
    subtract subobj= new subtract();
    multiplication mulobj= new multiplication();
    division divobj= new division();
    try(Scanner input = new Scanner(System.in)) {
        for(int i=0; i<=4;i++) {
            System.out.println("1.ADDITION\n2.SUBTRACTION\n3.MULTIPLICATION\n4.DIVISION\n5.EXIT");
            System.out.print("Choose Your Operator:");  
            int option= input.nextInt();

            while(option>=6 || option<=0){
                System.out.println("Please select one(1) to five(5).");
                option= input.nextInt();
            }

            if(option==5)
                return;

            System.out.println("Enter two number:");
            int number1= input.nextInt();
            int number2=input.nextInt();

            switch(option) {
            case 1:
                System.out.println("Addition:"+"("+ number1 +") + ("+ number2 +") =  "+ addobj.result(number1,number2));
                break;
            case 2:
                System.out.println("Subtraction:"+"("+ number1 +") - ("+ number2 +") = "+ subobj.result(number1,number2));
                break;
            case 3:
                System.out.println("Multiplication:"+"("+ number1 +") * ("+ number2 +") = "+ mulobj.result(number1,number2));
                break;
            case 4:
                while(number2==0){
                    System.out.println("Please enter non-zero value of second number:");
                    number2= input.nextInt();
                }
                System.out.println("Division:"+ "("+ number1 +") / ("+ number2 +") = "+ divobj.result(number1,number2));
                break;
            }
            System.out.println("\n");
       }
    }
}