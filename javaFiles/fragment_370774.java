public void writeInFile(String data){
    try{
        FileWriter fstream = new FileWriter("path-to-your-file");
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(data);
        out.close();
    }catch (Exception e){//Catch exception if any
        System.err.println("Error: " + e.getMessage());
    }
}