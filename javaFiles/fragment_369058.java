class ReportDirectory{

   static final String path = "./path/to/reports/"; //<-- generic path on your SERVER!

   static{
       //static initializer to make sure directory gets created.  Better ways to do this but this will work!

       File pathAsFile = new File(path).mkdirs()

       if (pathAsFile.exists()){
          println("CREATED REPORT DIRECTORY @ ${pathAsFile.absolutePath}");
       }else{
          println("FAILED TO CREATE REPORT DIRECTORY @ ${pathAsFile.absolutePath}");
       }

   }

   public static File[] listFiles(){
       return new File(path).listFiles(); //<-- maybe use filters to just pull pdfs?
   }

   public static void addFile(File file){
       FilesUtil.copyFileToDirectory(file, new File(path)); //<-- using apache-commons-io
   }

   public static void deleteAll(){
       listFiles().each(){ fileToDelete ->
           fileToDelete.delete();
       }
   }

   public static File findFile(String name){
       listFiles().each(){ fileToCheck ->

           if (fileToCheck.name.equals(name)){
               return fileToCheck
           }
       }
       return null
   }

}