BufferedReader b = new BufferedReader(new InputStreamReader(s.getInputStream()));
String output = "", line = "";
while((line = br.readLine()) != null) {
    output += line;
}
System.out.println(output);