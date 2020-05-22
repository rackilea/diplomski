//Part A
   int firstNum;
   int secondNum;
   int sumEven=0;

   System.out.println("Please enter an integer: ");
   firstNum = input.nextInt();

   System.out.println("Please enter another integer less than the first integer: ");
   secondNum = input.nextInt();

   //Part B

   //validate input in a loop
   while(true)
   {
     if (firstNum > secondNum)
     {
         System.out.print("Your second number is larger than the first.  So Please re-enter: ");
         secondNum = input.nextInt();
     }
     else
     {
         break;
     }
   }

       System.out.print("Odd Numbers: ");
       int loopCounter=firstNum;
       while(loopCounter<secondNum)
       {
         if (loopCounter%2!=0)
         {
             System.out.print(" " + loopCounter);
         }//end if
         else
         {
             sumEven+=loopCounter;
         }//end else
         loopCounter++;
       }

       System.out.println();
       System.out.print("Sum of Even Numbers: ");    
       System.out.print(sumEven);

   }