for(i=0;i<=3;i++)
  {
   temp = sc.nextLine();
   Temp = temp.split(" ");

       switch (Temp[1]) {
           case "PHP":
               conversion = Double.parseDouble(Temp[0])*51.23;
               System.out.println("$"+Temp[0]+" CONVERTS TO "+df.format(conversion)+" PHP.");
               break;
           // Other cases
           // ...
           // ...
           default:
               i--;
               System.out.println("Invalid input, Please try again");
       }
  }