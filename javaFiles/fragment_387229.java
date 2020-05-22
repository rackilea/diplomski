public static char run(String string) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please provide a string");
    String str1 = sc.next();
    if(str1.contains("Andy")) {
        return 'V'
    } else {
        return 'X'
    }
}