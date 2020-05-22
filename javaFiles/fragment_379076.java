final int LINES = 10;
// "tr" is a Unix command that translates characters;
// Here, for every line it reads, it will output a line with
// every 'a' character converted to 'A'.  But any command that outputs
// something for every line it reads (like 'cat') will work here
Process p = Runtime.getRuntime().exec("tr a A");
Writer out = new OutputStreamWriter(p.getOutputStream());
for (int i = 0; i < LINES; i++) {
    out.write("abcdefghijklmnopqrstuvwxyz\n");
}
out.close();
// Read all the output from the process and write it to stdout
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
while ((line = in.readLine()) != null) {
    System.out.println(line);
}