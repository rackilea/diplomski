try {

} catch (Exception e) {
    try {
        FileWriter fw = new FileWriter("mylog.txt", true)
        e.printStackTrace(new PrintWriter(fw));
        fw.close();
    } catch (IOException ioe) {
        System.out.println("I can't open the file mylog.txt");
    }
}