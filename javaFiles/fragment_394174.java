static {
    // avoid security issues
    StringBuilderWriter buf = new StringBuilderWriter(4);
    PrintWriter out = new PrintWriter(buf); //<-- kaboom here
    out.println();
    LINE_SEPARATOR = buf.toString();
    out.close();
}