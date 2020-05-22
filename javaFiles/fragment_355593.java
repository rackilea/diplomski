$ cat test.java
class test {
    public static void forfor() {
        int width = 15, height = 15;
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++) {
                // do stuff here
            }
    }

    public static void dofor() {
        int width = 15, height = 15, y = 0;
        do for (int x = 0; x++ < width;) {
            // do stuff here
        } while (y++ < height);
    }
}
$ javac test.java
$ javap -c test
  public static void forfor();
    Code:
       0: bipush        15
       2: istore_0
       3: bipush        15
       5: istore_1
       6: iconst_0
       7: istore_2
       8: iload_2
       9: iload_1
      10: if_icmpge     32
      13: iconst_0
      14: istore_3
      15: iload_3
      16: iload_0
      17: if_icmpge     26
      20: iinc          3, 1
      23: goto          15
      26: iinc          2, 1
      29: goto          8
      32: return

  public static void dofor();
    Code:
       0: bipush        15
       2: istore_0
       3: bipush        15
       5: istore_1
       6: iconst_0
       7: istore_2
       8: iconst_0
       9: istore_3
      10: iload_3
      11: iinc          3, 1
      14: iload_0
      15: if_icmpge     21
      18: goto          10
      21: iload_2
      22: iinc          2, 1
      25: iload_1
      26: if_icmplt     8
      29: return