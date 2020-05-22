String hex = "4a616d6573";
StringBuilder output = new StringBuilder();
for (int i = 0; i < hex.length(); i+=2) {
    String str = hex.substring(i, i+2);
    output.append((char)Integer.parseInt(str, 16));
}
System.out.println(output);