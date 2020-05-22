Scanner input = new Scanner(System.in);
        String str;

     while ((str = input.nextLine()) != null){

         if (str.equals("setFirst")){
             System.out.println("setFirst");
         }else if(str.equals("setSecond")){
             System.out.println("setSecond");
         } else if (str.equals("setOption")){
             System.out.println("Please type in option.");
         }

   }