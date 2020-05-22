public void openFileInFolder(String filename){

    try {
       Process ls_proc;

       String mvnClean = "open -R " + core.Loader.path + "/" + file_chosen;
       String OS = System.getProperty("os.name");

       System.out.println("OS is: " + OS);

       if (OS.contains("Windows")) {
           //code ...
       } else {
           ls_proc = Runtime.getRuntime().exec(mvnClean);
       }

     } catch (Exception e){
          System.err.println("exception");
     }
}