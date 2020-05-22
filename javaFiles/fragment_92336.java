try {
     int count =1;
     FileReader fr = new FileReader("InventoryReport.txt");
     BufferedReader br = new BufferedReader(fr);
     String str;

        while ((str = br.readLine()) != null) {

            br.close();
           } catch (IOException e) {
            if(count == 3) {
                 System.out.printIn("The program will now stop executing.");
                System.exit(0);
                count++;
                }
           }