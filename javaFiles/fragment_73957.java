String version = null;
try{
     version = getAppVersion();
}
catch (IOException ioe){
    ioe.printStackTrace();
}