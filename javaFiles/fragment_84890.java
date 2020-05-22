@Test
public void split3() {
    String[] array = "the DT  the".split("\\s+", 3);
    System.out.println(array[2]);

    array = "the DT  the foo bar".split("\\s+", 3);
    // last element will contain all the rest of the string.
    System.out.println(array[2]);

    array = "the DT".split("\\s+", 3);
    System.out.println(array[2]); // java.lang.ArrayIndexOutOfBoundsException: 2

    array = "the DT".split("\\s+");
    System.out.println(array[2]); // java.lang.ArrayIndexOutOfBoundsException: 2

    array = "the DT  the foo bar".split("\\s+");
    System.out.println(array[2]);
}