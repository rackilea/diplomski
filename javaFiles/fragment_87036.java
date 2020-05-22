String a = "ANGRY AARDVARK";
char[] aa = a.toCharArray();
for (int i = 0; i < aa.length; i++) {
    System.out.printf("Character at index %d=%c%n", i, aa[i]);
    if (aa[i] == 'A') {
        System.out.println("Character is A");
    }
}