if(check1==-1)
    {
        System.out.println("I think you forgot the ':'.");

    }
    else
    {
     String numbers [] = input1.split(":"); //if the user enter 1123:2342 this method 

     //will
     // return array of String which contains two elements numbers[0] = "1123" and numbers[1]="2342"
    System.out.print("first number = "+ numbers[0]);
    System.out.print("Second number = "+ numbers[1]);
    }