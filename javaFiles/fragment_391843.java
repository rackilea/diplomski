Scanner sc=new Scanner(System.in);
while (true){
    System.out.println("Enter two numbers (0 to quit):");

    float n1=sc.nextFloat();

    if (n1 == 0){
        break; //New part of the code
    }

    float n2=sc.nextFloat();
    float ans1=n1+n2;
    float ans2=n1*n2;
    float ans3=ans1 / ans2;
    System.out.println("Answer is "+ans3);
}