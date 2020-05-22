try {
    PrintWriter pw = new PrintWriter(new File("output.txt"));
    printLinkStatistics(logger, pw);
} catch (FileNotFoundException e) {
    e.printStackTrace(); //handle exception as you want
}