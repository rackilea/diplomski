BufferedReader b = new BufferedReader(new StringReader(myString));

String line;
while (!(line = b.readLine()).startsWith("-----")) {/*skip*/};

while ((line = b.readLine()) != null) {
    if (line.trim().equals("")) continue; // skip blank lines
    String[] splat = line.split(" +",4);
    System.out.println("Interface Name : " + splat[3]);
    System.out.println("Type : " + splat[2]);
    System.out.println("State : " + splat[1]);
    System.out.println("Admin State : " + splat[0]);
}
b.close();