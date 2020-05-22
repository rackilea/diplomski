String s = "";
public void keyTyped(KeyEvent keyEvent) {
    char c = keyEvent.getKeyChar();
    String s = s.concat(String.valueOf(c));
    try {
        PrintWriter out = new PrintWriter("test.txt");
        out.print(s);
        out.close();
    } catch (FileNotFoundException x) {
        x.printStackTrace();
    }
}