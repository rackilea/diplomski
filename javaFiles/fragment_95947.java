ProcessBuilder processBuilder = new ProcessBuilder();
Path workingDir = Paths.get("D:\\Java Projects\\imageProject");
processBuilder.directory(workingDir.toFile()); // Edited here
processBuilder.command(".\\screenshot-cmd");
try {
    processBuilder.start();
} catch (Exception ex) {
    ex.printStackTrace();
}