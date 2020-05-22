BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File("text.txt")))));

String line = null;

while ((line = reader.readLine()) != null) {
    // do something with your read line
}
reader.close();