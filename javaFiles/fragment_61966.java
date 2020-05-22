/**
    * Start this very jar file elevated on Windows. It is strongly recommended to close any existing IO
    * before calling this method and avoid writing anything more to files. The new instance of this same
    * program will be started and simultaneous write/write or read/write would cause errors.
    * @throws FileNotFoundException if the helper vbs script was not found
    * @throws IOException if there was another failure inboking VBS script
    */
   public void StartWithAdminRights() throws FileNotFoundException, IOException {
     //The path to the helper script. This scripts takes 1 argument which is a Jar file full path
     File runAsAdmin = new File("run-as-admin.vbs");;
     //Our 
     String jarPath;

     //System.out.println("Current relative path is: " + s);

     try {
       jarPath = "\""+new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getAbsolutePath()+"\"";
     } catch (URISyntaxException ex) {
       throw new FileNotFoundException("Could not fetch the path to the current jar file. Got this URISyntax exception:"+ex);
     }
     //If the jar path was created but doesn't contain .jar, we're (most likely) not running from jar
     //typically this happens when running the program from IDE
     //These 4 lines just serve as a fallback in testing, should be deleted in production
     //code and replaced with another FileNotFoundException
     if(!jarPath.contains(".jar")) {
       Path currentRelativePath = Paths.get("");
       jarPath = "\""+currentRelativePath.toAbsolutePath().toString()+"\\AutoClient.jar\"";
     }
     //Now we check if the path to vbs script exists, if it does we execute it
     if(runAsAdmin.exists()) {
       String command = "cscript \""+runAsAdmin.getAbsolutePath()+"\" "+jarPath;
       System.out.println("Executing '"+command+"'");
       //Note that .exec is asynchronous
       //After it starts, you must terminate your program ASAP, or you'll have 2 instances running
       Runtime.getRuntime().exec(command);

     }
     else
       throw new FileNotFoundException("The VBSScript used for elevation not found at "+runAsAdmin.getAbsolutePath());
   }