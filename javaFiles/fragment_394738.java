static String[] lines = new String[]{
    "Dec 31 19:50:15 ---",
    "Dec 31 21:50:15 ---",
    "Dec 31 23:50:15 ---",
    "Jan 1 00:50:15 ---",
    "Jan 1 01:50:15 ---" };
static int pos = 0;
static String getLine(){
return pos < lines.length ? lines[pos++] : null;
}