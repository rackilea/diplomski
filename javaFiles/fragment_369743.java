public static void main(String[] args) {

    // Step 1 ) get old text
    String oldText = "";
    try {
        oldText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
    } catch (UnsupportedFlavorException ufe) {
        ufe.printStackTrace();
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

    // Step 2 ) paste our text in clipboard
    setClipboard("This lorem ipsum predefined string blows my mind.");

    // Step 3 ) trigger paste event
    Robot robot = null;
    try {
        robot = new Robot();
    } catch (AWTException awte) {
        awte.printStackTrace();
    }
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);

    // Step 4 ) Release paste event
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);

    // Step 5 ) Reset clipboard
    setClipboard(oldText);

}