File file = new File("/tmp/deleteme.txt");
file.deleteOnExit();

long start = System.nanoTime();
PrintWriter pw = new PrintWriter(file);
for (int i = 0; i < 4 * 1000 * 1000; i++)
    pw.println("01234567890123456789012345678901234567890123456789");
pw.close();

long mid = System.nanoTime();
BufferedReader data = new BufferedReader(new FileReader(file));
String s;
while ((s = data.readLine()) != null) {
    //do stuff
}
data.close();
long end = System.nanoTime();

System.out.printf("Took %.3f seconds to write and %.3f seconds to read a %.2f MB file.%n",
        (mid - start) / 1e9, (end - mid) / 1e9, file.length() / 1e6);