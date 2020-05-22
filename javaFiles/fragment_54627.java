ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(tabs2.size());

        for (int i = tabs2.size()-1; i>=0; i--) {
            Thread.sleep(2000);
            driver.switchTo().window(tabs2.get(i));
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            System.out.println(driver.getTitle() + "i: " + i);
           // do what you needed
        }