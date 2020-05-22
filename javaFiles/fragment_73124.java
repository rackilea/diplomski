String input = "011000010110001001100011011001000110010101100110";
StringBuilder sb = new StringBuilder();
for (int i = 0; i < input.length(); i += 8) {
    int c = Integer.parseInt(input.substring(i, i + 8), 2);
    sb.append((char) c);
}
System.out.println(sb); // abcdef