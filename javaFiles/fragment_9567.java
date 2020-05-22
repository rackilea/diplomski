public void loopMethod(){
    if(!Shell.silentShellCommand(stringCommand).contains("Device detected")){
        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        loopMethod();
    }
}