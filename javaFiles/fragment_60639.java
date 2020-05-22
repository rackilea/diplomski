Reader reader = ...;
StringBuilder sb = new StringBuilder();
int ch;
while((ch = reader.read()) >= 0) {
    if(ch == '.') break;
    sb.append((char) ch);
}