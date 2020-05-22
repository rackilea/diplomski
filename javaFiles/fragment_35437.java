Actions actions = new Actions(driver)
actions.keyDown(Keys.CONTROL)
       .click(list.get(0))
       .click(list.get(4))
       .keyUp(Keys.CONTROL)
       .build();
       .perform();