Robot robot = null;
try
{
    robot = new Robot();
    robot.mouseMove(260, 500);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    // robot.mouseMove(660,700);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);

    robot.keyPress(KeyEvent.VK_CONTROL); // Select all
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    robot.keyPress(KeyEvent.VK_CONTROL); // Copy
    robot.keyPress(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    try
    {
        //sleep just a little to let the clipboard contents get updated
        Thread.sleep(25);
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }

    Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
    try
    {
        if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor))
        {
            String text = (String) t.getTransferData(DataFlavor.stringFlavor);
            System.out.println(text);
        }
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}
catch (AWTException ex)
{
    System.err.println("Can't start Robot: " + ex);
}