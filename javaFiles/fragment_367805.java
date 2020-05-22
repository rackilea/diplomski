try{
      FileWriter   fw = new FileWriter("myfile.txt", true); //Well a little better
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw);
    }catch (IOException e){

    }