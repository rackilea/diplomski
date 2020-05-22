class ConcurrentFileReader implements Runnable{
   String fileName;

   public ConcurrentFileReader(String fileName){ 
       this.fileName = fileName; 
   }

   public void run(){
       File f = new File(fileName);
      // whatever
   }
}