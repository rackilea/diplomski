String s[] = {"this is %animal%", "this is %bird%"};
for (int i = 0; i < s.length; i++) {
    s[i].replaceAll("%animal%", "cow");
    s[i].replaceAll("%bird%", "dove");
    System.out.println(s[i]);
}