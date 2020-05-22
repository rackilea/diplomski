Select allFromListData = new Select(listData);
    // values selection
    allFromListData.selectByIndex(0);
    allFromListData.selectByVisibleText("Helena");
    List<WebElement> selectedList=allFromListData.getAllSelectedOptions();

    //add selected Items to list
    List<String> lstSelectedItem=new ArrayList<String>();
    for(int i=0;i<selectedList.size();i++){
        System.out.println(selectedList.get(i).getText());
        lstSelectedItem.add(selectedList.get(i).getText());
    }

    //clicking on add button
    WebElement addButton = driver.findElement(By.xpath("//*[@id='pickList']/div/div[2]/button[1]"));
    addButton.click();

    //Verification of selected content... 
    WebElement toListData=driver.findElement(By.xpath("//*[@id='pickList']/div/div[3]/select"));
    Select allToListData = new Select(toListData);
    List<WebElement> movedData=allToListData.getOptions();

    //add moved Items to list
    List<String> lstMovedItem=new ArrayList<String>();
    for(int i=0;i<movedData.size();i++){
        System.out.println(movedData.get(i).getText());
        lstMovedItem.add(movedData.get(i).getText());
    }

    //sort the items
    Collections.sort(lstSelectedItem);
    Collections.sort(lstMovedItem);

    //verify the lists are equal
    Assert.assertEquals(lstSelectedItem, lstMovedItem);