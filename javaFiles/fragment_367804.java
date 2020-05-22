FileWriter fw = null; // Very pointles...
    try{
        fw = new FileWriter("myfile.txt", true);
    }catch (IOException e){

    }
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);