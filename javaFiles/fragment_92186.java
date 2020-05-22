class PrependPrintStream extends PrintStream {

PrependPrintStream(PrintStream ps, String pre){...}
...
public void print(boolean b) {
super.print(this.pre);
super.print(b);
}
...