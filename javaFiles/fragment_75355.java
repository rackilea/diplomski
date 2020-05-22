while (line.contains("[abc]") && line.contains("[cde]")) {
    int b = line.indexOf("abc");
    int cc = line.indexOf("cde");
    String tk = line.substring(b + 4, cc);
    System.out.println(tk);
    line = line.substring(cc + 4);
}