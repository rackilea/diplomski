public void foo(String text) {
   String path = new String(text);
   FileWriter wrtr = null;

   switch (path) {
    case aaa:
        wrtr = new FileWriter(aaa);
        break;
    case bbb:
        wrtr = new FileWriter(bbb);
        break;
    case ccc:
        wrtr = new FileWriter(ccc);
        break;
    }
}