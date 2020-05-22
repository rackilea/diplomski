Scanner scanner = new Scanner(new File("Algorithms.txt"));

    while(scanner.hasNext()){

         String data = scanner.nextLine();     // your line          
         String[] arguments = data.split(","); // split the line

         // getting data for each data inside the line
              String fromstate = arguments[0];
                String read = arguments[1];
                String tostate = arguments[2];
                String write = arguments[3];
                int move = Integer.parseInt(arguments[4]);

               System.out.println(fromstate+"-"+read+"-"+tostate+"-"+write+"-"+move);

        }