public static Boolean downloadModThread(String mod, String saveLoc, JProgressBar progress){
    new Thread(
        new Runnable(){
            public void run(){

                downloadMod(mod, saveLoc, progress);
            }
        }
    ).start();
    return true;

}