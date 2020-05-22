try {
    bot = new Robot();
} catch (AWTException e) {
    e.printStackTrace();
}

while (pressed) {
    bot.mousePress(InputEvent.BUTTON1_MASK);
    //bot.mouseRelease(InputEvent.BUTTON1_MASK);
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}