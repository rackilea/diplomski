Actions builder = new Actions(driver);

   Action dragAndDrop = builder.clickAndHold(someElement)
       .moveToElement(otherElement)
       .release(otherElement)
       .build();

   dragAndDrop.perform();