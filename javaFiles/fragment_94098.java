public void testRegex() {
    String str = "Hello. my Name is [[Peter.java]].";

    String[] arr = str.split("[.,\\s]+(?!\\w+])");

    System.out.println(Arrays.toString(arr));
}
// Output: [Hello, my, Name, is, [[Peter.java]]]