public static void main(String[] args) {
        System.out.print("Phase: ");
        Scanner sp = new Scanner(System.in);
        String p;
        p = sp.nextLine();

        System.out.print("Database: ");
        Scanner sd = new Scanner(System.in);
        String d;
        d = sd.nextLine();

        System.out.print("IP address: ");
        Scanner sip = new Scanner(System.in);
        int ip = sip.nextInt();

        {
         try
             {
             File file = new File("C://users//James//Desktop//newcommand.txt");
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = reader.readLine()) != null)
                 {
                 oldtext += line + "\r\n";
             }
             reader.close();

             String replacedtext  = oldtext.replaceAll("phase", "" + p);
             replacedtext = replacedtext.replaceAll("db", "" + d);
             replacedtext = replacedtext.replaceAll("IP", "" + ip);

             FileWriter writer = new FileWriter("C://users//James//Desktop//newcommand.txt");
             writer.write(replacedtext);


             writer.close();

         }
         catch (IOException ioe)
             {
             ioe.printStackTrace();
         }
     }