double val = 0.0;
Scanner fScn = new Scanner(new File(“date.txt”));
while(fScn.hasNextLine()){   //Can also use a BufferedReader
    data = fScn.nextLine();
    if(data.contains("|"))    //Ensure line contains "|"
        val = Double.parseDouble(data.substring(0, data.indexOf("|")));  //grab value
}