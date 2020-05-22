FileWriter fw = new FileWriter("mylog.txt", true);
PrintWriter pw = new PrintWriter(fw);
try {

} catch (Exception e) {
    try {
        e.printStackTrace(pw);
    } catch (IOException ioe) {
        System.out.println("I can't open the file mylog.txt");
    }
}finally {
     pw.close();
     fw.close();
}