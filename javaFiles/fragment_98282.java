List<WebElement> gridRows = driver.findElements(By.cssLocator("[class*='MuiGrid- 
root campaign-usecase-item']"));
int totalGridCells = gridRows.size;
int reuiredGridRowIndex;
for(int i=0' i<totalGridCells; : i++){
    if(gridRows.get(i).findElements(By.cssLocator("[class*='MuiGrid-root MuiGrid- 
    item']:not([style])").get(0).getText().equals("2FA")){
    // 2fa value will be dynamic and pass as function argument
    reuiredGridRowIndex = i;
    break;
     }
}