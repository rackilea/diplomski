List<WebElement>list = driver.findElements(eventListItem);
    int counter = 0;
    for(WebElement we : list){
        if(we.getText().contains(eventName)){
            js.executeScript("return AutonEdit.Main.AutoSequenceItems()[0]"
                    + ".AutoEvents.push(AutoEdit.Main.EventList()[" + counter +"]);");
            break;
        }
        counter++;
    }