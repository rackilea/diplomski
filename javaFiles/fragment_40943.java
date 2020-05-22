...
while (s.hasNextLine()) {
    String line = s.nextLine();
    lastString = lastString + line;
}
StringBuffer result = new StringBuffer();
for (int i = 0; i < lastString.length(); i += 8) {
    result.append((char) Integer.parseInt(lastString.substring(i, i + 8), 2));
}
System.out.println(result); 
...