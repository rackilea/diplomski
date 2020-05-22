void startOtherApp(String[] args) {
    final String ENCODING = "UTF-8";
    PrintStream oldOut = System.out;
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (PrintStream out = new PrintStream(baos, false, ENCODING)) {
        System.setOut(out);
        OtherJarsMain.main(args);
        out.flush();
        System.setOut(oldOut);
        String s = baos.toString(ENCODING);
        System.out.println("OUTPUT:\n" + s);
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
    }
}