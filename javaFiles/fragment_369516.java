for (int row = 0; row < totalNoOfRows; row++) {

    for (int col = 0; col < totalNoOfCols; col++) {
        System.out.print(sh.getCell(col, row).getContents() + "\t"); //don't understand what you want to achieve using this
        Thread.sleep(3000);
         switch(col){
             Case 0: wd.findElement(By.id("name")).sendKeys(sh.getCell(col, row).getContents());
                     break;
              Case 1: wd.findElement(By.id("email")).sendKeys(sh.getCell(col, row).getContents());
                     break;
              Case 2: wd.findElement(By.id("phone")).sendKeys(sh.getCell(col, row).getContents());
                     break;
              Case 3: wd.findElement(By.id("mob")).sendKeys(sh.getCell(col, row).getContents());
                     break;
              Case 4: wd.findElement(By.id("address")).sendKeys(sh.getCell(col, row).getContents());
                     break;

    }
}
}