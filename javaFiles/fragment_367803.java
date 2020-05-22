FileWriter fw;
    try{
        fw = new FileWriter("myfile.txt", true); ==> An exception can happen
    }catch (IOException e){
           nothing to do... 
    }
    BufferedWriter bw = new BufferedWriter(fw); ==> fw is not initialized..
    PrintWriter out = new PrintWriter(bw);