public static void main(String[] args) {

    //"where" on Windows and "whereis" on Linux/Mac
    if (System.getProperty("os.name").contains("win") || System.getProperty("os.name").contains("Win")) {
        String path = getCommandOutput("where javac");
        if (path == null || path.isEmpty()) {
            System.err.println("There may have been an error processing the command or ");
            System.out.println("JAVAC may not set up to be used from the command line");
            System.out.println("Unable to determine the location of the JDK using the command line");
        } else {
            //Response will be the path including "javac.exe" so need to
            //Get the two directories above that
            File javacFile = new File(path);
            File jdkInstallationDir = javacFile.getParentFile().getParentFile();
            System.out.println("jdk in use at command line is: " + jdkInstallationDir.getPath());
        }//else: path can be found
    } else {
        String response = getCommandOutput("whereis javac");
        if (response == null) {
            System.err.println("There may have been an error processing the command or ");
            System.out.println("JAVAC may not set up to be used from the command line");
            System.out.println("Unable to determine the location of the JDK using the command line");
        } else {
            //The response will be "javac:  /usr ... "
            //so parse from the "/" - if no "/" then there was an error with the command
            int pathStartIndex = response.indexOf('/');
            if (pathStartIndex == -1) {
                System.err.println("There may have been an error processing the command or ");
                System.out.println("JAVAC may not set up to be used from the command line");
                System.out.println("Unable to determine the location of the JDK using the command line");
            } else {
                //Else get the directory that is two above the javac.exe file
                String path = response.substring(pathStartIndex, response.length());
                File javacFile = new File(path);
                File jdkInstallationDir = javacFile.getParentFile().getParentFile();
                System.out.println("jdk in use at command line is: " + jdkInstallationDir.getPath());
            }//else: path found
        }//else: response wasn't null
    }//else: OS is not windows
}//end main method