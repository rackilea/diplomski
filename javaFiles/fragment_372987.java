static PrintWriter pw ;
static {
   try{
     pw = new PrintWriter("Results.txt", "UTF-8");
     }
     catch(IOException e){
        e.printStackTrace();
        throw new RuntimeException(e);  
    }
}