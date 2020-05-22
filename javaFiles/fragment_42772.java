public static void alt(int event1, int event2, int event3, int event4) throws Exception {

    Robot bot = new Robot();
    bot.delay(50); //Optional
        bot.keyPress(KeyEvent.VK_ALT);

            bot.keyPress(event1);
            bot.keyRelease(event1);

            bot.keyPress(event2);
            bot.keyRelease(event2);

            bot.keyPress(event3);
            bot.keyRelease(event3);

            bot.keyPress(event4);
            bot.keyRelease(event4);

        bot.keyRelease(KeyEvent.VK_ALT);

}