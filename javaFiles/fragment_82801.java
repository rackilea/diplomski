FileReader fr = new FileReader(filename);
BufferedReader br = new BufferedReader(fr);
StringBuilder sb  = new StringBuilder();
String s;
while((s = br.readLine()) != null) {
sb.append(s);
}