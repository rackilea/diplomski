String str = "abc";
char c[] = str.toCharArray();

for (int k = 0; k < c.length; k++) {
    if (c[k] == 'b') {
        System.out.println("yes");
    } else {
        System.out.println("no");
    }
}