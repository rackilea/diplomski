String x = jTextField1.getText();
for (int i = 0, len = x.length(); i < len; i++) {
    char ch = x.charAt(i);
    if (i % 2 == 0) {
        System.out.print(Character.toLowerCase(ch));
    } else {
        System.out.print(Character.toUpperCase(ch));
    }
}
System.out.println();