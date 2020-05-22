private String getWorkingChar(){
    String workingDir = System.getProperty("user.dir");
    String workingChar = "/";

    if (workingDir.indexOf("\\") != -1) {
        workingChar = "\\";
    }

    return workingChar;
}