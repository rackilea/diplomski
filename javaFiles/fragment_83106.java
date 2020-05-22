Robot bot = new Robot();
bot.setAutoDelay(1);

int duration = 3000;
long start = System.currentTimeMillis();
while (System.currentTimeMillis() - start < duration) {
    bot.keyPress(KeyEvent.VK_R);
    bot.keyRelease(KeyEvent.VK_R);
}