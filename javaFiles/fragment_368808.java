public static void main(String arg[]) {
  try { 
    Class.forName("my.OtherMain");

    // worked, call it
    OtherMain.main();
  } catch(ClassNotFoundException e) {
    // fallback to some other behavior
    doOtherThing();
  }
}