public static void main(String argv[]) {
    String str = "Test numbers test count gggg aaaaaa";
    System.out.println(rplcWordWithSize(3, str));  //Test numbers test count gggg aaaaaa
    System.out.println(rplcWordWithSize(4, str));  //SUPER numbers SUPER count SUPER aaaaaa
    System.out.println(rplcWordWithSize(5, str));  //Test numbers test SUPER gggg aaaaaa
}