for (int i=0 ; i < s1.length()-1; i++) {
    char c = s1.charAt(i);
    if (c >= 'A' && c <= 'Z') {
        s2.append(s1.charAt(i+1));
    }
}
System.out.println(s2);