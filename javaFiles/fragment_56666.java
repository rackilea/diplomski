Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number to convert to binary: ");
        int x = input.nextInt();
        int y;
        String y1="";
        String reverse = "";
        while(x!=0){
           y=x%2;
           x=x/2;
           y1 = Integer.toString(y);
         //  System.out.print(y1+" ");
           reverse = y1+" "+reverse;
         }          
        System.out.println("Reverse Order :"+reverse);