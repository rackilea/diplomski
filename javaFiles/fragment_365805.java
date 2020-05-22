private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    String sql="select * from app_1 where id_user_main=?";  
    String jacobDllVersionToUse;
        if (jvmBitVersion().contains("32")){
            jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
        }
        else {
            jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
        }
     try{ 
    File file = new File("lib", jacobDllVersionToUse);
    System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
    AutoItX x = new AutoItX();
    x.run("Skype", "C:/Program Files (x86)/Skype/Phone", AutoItX.SW_SHOW);
    x.winWait("Skype");
    x.winActivate("Skype");
    x.winWaitActive("Skype");
    x.sleep(2000);
    x.send("{TAB}!n", false );

     }catch(Exception e){

   } 
}