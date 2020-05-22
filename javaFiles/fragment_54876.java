Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        // try catch for forcing Escape key press
        try {
            Robot robObject = new Robot();
            robObject.keyPress(KeyEvent.VK_ESCAPE);
            robObject.keyRelease(KeyEvent.VK_ESCAPE);
            System.out.println("press");
        } catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
});
t.start();