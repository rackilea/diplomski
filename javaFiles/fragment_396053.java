int a=25; 
for (double i=1;i<=a;i++) { 
    int b = 5 * (int)i;
    boolean value = b == a; 
    if (value) {
        System.out.println("true");
        break;
    }
}