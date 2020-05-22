public void go()
    {
        try 
        {
            System.out.println("Opening WinSCP");
            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec("C:\\Program Files (x86)\\WinSCP\\WinSCP.exe");
            Robot r = null;
            try 
            {
                Thread.sleep(2000);
                r = new Robot();
                r.keyPress(KeyEvent.VK_ENTER);
                r.keyRelease(KeyEvent.VK_ENTER);

            } 
            catch (AWTException | InterruptedException e) 
            {
                e.printStackTrace();
            } 
        } 
        catch (IOException e)
        {
        e.printStackTrace();
        }
}