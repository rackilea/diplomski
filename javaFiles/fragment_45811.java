BufferedWriter w = null;
try { w = ... }
catch (FileNotFoundException | UnsupportedEncodingException e) {
    System.out.println(e.getMessage());
}

if (w != null) {
    w.write("Test string");
    w.newLine();
}