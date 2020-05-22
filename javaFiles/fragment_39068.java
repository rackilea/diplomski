public void readDatabase(String s) throws FileNotFoundException{    
    try {               
        final BufferedReader br = new BufferedReader(new FileReader(s));
        String line = br.readLine();
        while(line != null) {
            line = line.replace(',', '.');
            final Scanner lineScanner = new Scanner(line);
            if(!scanner.hasNextDouble())
                break;// quit loop
            // else continue loop
            double x = lineScanner.nextDouble();
            double y = lineScanner.nextDouble();
            int type = lineScanner.nextInt();
            this.database.add(new Point(x,y,type));
            line = br.readLine();
        }   
        br.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}