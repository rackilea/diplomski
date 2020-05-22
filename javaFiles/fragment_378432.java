String names[] = new String[5]; // sets array size to almost unlimited #
            double prices[] = new double[100]; // sets array size to almost unlimited #
            double average = 0; // initializes the array 
            int count = 0; // initializes the count for the arraysize
            boolean flag = false;// initializes flag to false so it can be changed later


            while(true){
           System.out.print("Enter item " + (count + 1) + " name: "); // enter name
           names[count] = System.console().readLine();//in.next(); // next string becomes count index
           if(names[count].equals("-1")){ break;} // if the next name entered is sentinel break
           System.out.print("Enter item " + (count + 1) + " price: "); // enter price
           prices[count] = Double.valueOf(System.console().readLine());//in.nextDouble(); // stores price entered as array index
            // if next price == -1 then the program ends
           if(names[count].equalsIgnoreCase("peas")) flag = true;
           average += prices[count];
           count++;
//     }//deleted

            System.out.println("The items and their prices are: ");
            for(int i = 0; i < count; i++){
           System.out.println(names[i] + ": " + prices[i]);//formatter.format()
//     }//deleted
            average /= count;
            //if(flag == true){
           System.out.println("Average: " + average);//formatter.format()
       //}
            else{
                System.out.println("no average output");
       }//added
       }//added
       }