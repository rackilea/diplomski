public void getTotalMemory() {
String path = "/proc/$pid/stat";
String info="";
try {
    FileReader fr = new FileReader(path);
    BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
    while ((info = localBufferedReader.readLine()) != null) {
        //analyse 
        System.out.println("ThreadInfo:" + info);
    }
    // close...
    } catch (IOException e) {
    }
}