int a=25; 
for (double i=1;i<=a;i++) { 
    int b = 5 * (int)i;  // you must cast "i" in order for this to compile 
    boolean value = b == a;  // you probably wanted "b == a" not "b == i" 
    if (value)
        System.out.println("true");
}