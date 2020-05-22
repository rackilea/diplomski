ProcessBuilder processBuilder = new ProcessBuilder("D:\\Java Projects\\imageProject\\screenshot-cmd");
try {
    processBuilder.start();
} catch (Exception ex) {
    ex.printStackTrace();
}