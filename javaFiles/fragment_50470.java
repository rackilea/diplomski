String filePath = "/dir1/testFile.txt";
try {
    System.out.println("No: of lines : ");
    ProcessBuilder pb = new ProcessBuilder("wc", "-l", filePath);
    pb.inheritIO();
    Process p = pb.start();
    p.waitFor();
} catch (Exception e) {
    e.printStackTrace();
}