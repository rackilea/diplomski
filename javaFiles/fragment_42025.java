FileReader fr1 = new FileReader("Name.txt");
BufferedReader br1 = new BufferedReader(fr1);
String str = null;
for (int i = 1; i <= x; i++) {
    str = br1.readLine();
}
br1.close();