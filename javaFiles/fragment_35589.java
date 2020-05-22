FileReader fr = new FileReader("test.txt");
BufferedReader br = new BufferedReader(fr);

FileWriter wr = new FileWriter("new.txt");
String s;
BufferedWriter bw = new BufferedWriter(wr);
while ((s = br.readLine()) != null) {
    if (s.startsWith("Text:"))
        bw.write(s);
}
br.close();
bw.close();