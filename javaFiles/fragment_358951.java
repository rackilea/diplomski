public static void main(String... args) {
    Object x = null;
    //Bad:
    if (x != null) {
       // logic
    }

    //Good:
    if (x == null){
    } else {
      // logic
    }
}