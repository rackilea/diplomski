File dir =  new File(SYS_CONFIG_FILE_PATH, SYS_CONFIG_DIR_NAME);
f.mkdirs(); // this to create the directories need for your path.
File file = new File(dir, SYS_CONFIG_FILE_NAME);
if (file.createNewFile()) {
   system.out.prinln("file first created"); 
   }else {
   // print a message here
   }
   return file;