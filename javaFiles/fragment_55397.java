String str = "\\u0BAB\\u0BCD\\u0BAA";
StringBuilder sb = new StringBuilder();

for (int i = 0; i < str.length(); i += 6) {
    String chStr = str.substring(i+2, i+6);
    sb.append((char) Integer.parseInt(chStr, 16));
}

System.out.println("Result: " + sb.toString());