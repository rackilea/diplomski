int val = 0;
BufferedReader br = new BufferedReader(new FileReader("out.txt"));

String line = null;
while(true) {
    line = br.readLine();
    if (line == null) break;
    val = Integer.parseInt(line.trim());
}
br.close();