int last = 0;
     int beforeLast = 0;
     do {
         menu();
         option=input.nextInt();

         switch (option) {

         case 1:

            System.out.print("Please enter a number between 0 and 20 : "  ); 
            no=input.nextInt();
            beforeLast = last;
            last = no;
            break;
         case  2:
            System.out.println("The Sum of the Numbers is : " + (last+beforeLast));

         default :
             System.out.print("Invalid option");


         } 
    } while (option !=5);