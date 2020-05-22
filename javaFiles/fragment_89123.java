public static void addRows(String fileName) 
    {
    int count = 0;
    int x;
    try 
     {

        Scanner s = new Scanner(new File(fileName));


        while (s.hasNextLine()) 
        {
          String line = s.nextLine(); // get the next line
          Scanner lineScanner = new Scanner (line); // get a new scanner for the next line! Done! Now proceed the usual way.

            while (lineScanner.hasNextInt()) 
               {
                  x = lineScanner.nextInt();
                  count += x;
               }

            System.out.println(count);
            count = 0;

        }


     }
    catch(IOException e) 
     {
         System.out.println("No File Found.");
     }
   }