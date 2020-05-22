public void readDatabase(String s) throws FileNotFoundException{    
    try {               
        final BufferedReader br = new BufferedReader(new FileReader(s));
        final Scanner trainFile = new Scanner(br);
        while (trainFile.hasNextDouble()) {      
            double x = trainFile.nextDouble();
            double y = trainFile.nextDouble();
            int type = trainFile.nextInt();
            this.database.add(new Point(x,y,type));
        }   
        trainFile.close();
        br.close();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
}