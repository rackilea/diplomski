String[][] x = new String[][] {
    new String[] { "foo", "bar" },
    new String[] { "bazz" }
};
Log.d("this is my deep array", "deep arr: " + Arrays.deepToString(x));
// or
System.out.println("deep arr: " + Arrays.deepToString(x));
// will output: [[foo, bar], [bazz]]