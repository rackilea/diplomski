@Test
public void checkForWhatever() {
    // prepare everything here like create a temp file
    File x = ...;
    String filename = x.getName(); // or maybe even x.getAbsolutePath();

    String[] arguments = new String[1];
    arguments[0] = filename;

    // now call your constructor
    myClass obj = new myClass(arguments);

    // do any checks here now
    Assertions.assertTrue(obj.getWhatever());
    // ...
}