List<WebElement> row = getDriver().findElements(By.cssSelector(".igg_ListItem > tr > td:nth-child(1)"));
    for (int i =0; i<row.size();i++) {
    String status = row.get(i).getText();

    if (status.equalsIgnoreCase("Vendor Assignment Expired")) {
        if (row.get(i-1).getText().equalsIgnoreCase("Vendor Accepted Assignment") 
                && row.get(i+1).getText().equalsIgnoreCase("Vendor Declined Assignment"))
        System.out.println("Yes it between those values");
        break;
    }
}