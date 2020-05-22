public void runMyScript(String aFirstArg, String aSecondArg){

     ProcessBuilder procBuildScript = new ProcessBuilder("./your-script.sh",aFirstArg,aSecondArg);
     procBuildScript.start();

}