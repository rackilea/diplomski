public String getWebappsDirectory(){
    String workingDir = System.getProperty("user.dir");
    String workingChar = getWorkingChar();

    //other deploy
    return workingDir + workingChar + "webapps" + workingChar;

    //main deploy
    //return workingDir + workingChar + ".." + workingChar + "webapps" + workingChar;
}