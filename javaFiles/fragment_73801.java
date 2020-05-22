public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
    Robot robot = new Robot();
    String text = "Hello";
    File file = File.createTempFile("tmp", ".txt");

    if (Desktop.isDesktopSupported()) {
        Desktop.getDesktop().edit(file);
        Thread.sleep(1000);
    } else {
        // dunno, up to you to handle this
    }
    for (char c : text.toCharArray()) {
        int keyEvent = KeyEvent.getExtendedKeyCodeForChar(c);
        robot.keyPress(keyEvent);
        Thread.sleep(500);
    }
    }
}