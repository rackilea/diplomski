public void myCallingMethod() throws IOException{
    File rep = new File("report.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(rep));
    walk("my/path", 4, bw);
    bw.close();
}