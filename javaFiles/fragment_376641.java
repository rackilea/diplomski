try {
    float netTotal = 0;
    String thisLine = null;
    FileOutputStream out = new FileOutputStream("out.txt"); 
    BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"));
    while ((thisLine = br.readLine()) != null) { // while loop begins here
        String[] parts = thisLine.split("[\\t\\n\\r ]+");
        int askingPrice = Integer.parseInt(parts[1]); 
        int salePrice = Integer.parseInt(parts[2]);
        int amountOwed = Integer.parseInt(parts[3]);
        float commission = salePrice * 0.06;
        float tax = salePrice * 0.105;
        float netPrice = askingPrice - amountOwed - commission;
        netTotal += netPrice;

        out.write((parts[0] + "\t").getBytes());       //name
        out.write((askingPrice + "\t").getBytes());    //asking price
        out.write((amountOwed + "\t").getBytes());     //mortgage amount
        out.write((salePrice + "\t").getBytes());      //selling price
        out.write((commission + "\t").getBytes());     //realtor commission
        out.write((tax + "\t").getBytes());            //sales tax
        out.write((netPrice + "\t\n").getBytes());     //net price
    }
    out.close(); 
    br.close();
    System.out.println("Net profit/loss:  " + netTotal);
} 
catch (Exception e) {
    e.printStackTrace();
}