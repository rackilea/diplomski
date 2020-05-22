File file = new File("mytestfile.txt");
int linesRead = 0;
long progress = 0;
long fileLength = file.length();
String line;

CountingInputStream cis = new CountingInputStream(new FileInputStream(file));
BufferedReader br = new BufferedReader(new InputStreamReader(cis, "UTF-8"), 8192);
while ((line = br.readLine()) != null) {
    long newProgress = cis.getBytesRead();
    if (progress != newProgress) {
        progress = newProgress;
        int percent = (int) ((progress * 100) / fileLength);
        System.out.println(String.format("At line: %4d, bytes: %6d = %3d%%", linesRead, progress, percent));
    }
    linesRead++;
}
System.out.println("Total lines: " + linesRead);
System.out.println("Total bytes: " + fileLength);
br.close();