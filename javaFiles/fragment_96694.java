for (int i = 0; i < str.length(); i++) {
    char a = (char) rand.nextInt(range);
    sb.append(str.charAt(i));
    sb.append(a);
}
return sb.toString();