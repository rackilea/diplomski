StringBuffer sb = new StringBuffer();
while (br.ready()) {
    char[] c = new char[] { 1024 };
    br.read(c);
    sb.append(c);
}