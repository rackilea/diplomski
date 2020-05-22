String s = "hello❤️ #xyz";
StringBuffer sb = new StringBuffer();
for (char ch : s.toCharArray()) {
    if(ch >= 32 && ch <= 126)
        sb.append(ch); // ch is a printable ASCII character
    else
        sb.append(String.format("\\u%04X", (int)ch));       
}
System.out.printf(sb.toString());