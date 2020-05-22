StringBuilder sb = new StringBuilder();
char[] chars = text.toCharArray();
char previous = chars[0];
sb.append(chars[0]);
for(int i = 1 ; i < chars.length ; i++) {
    if(chars[i] != previous) {
        sb.append(chars[i]);
        previous = chars[i];
    }
}
String res = sb.toString();