for (int Count = 5; Count <=10; Count++)    {

Utility.ExcelUtils.setExcelFile(Utility.Constant.Path_TestData + Utility.Constant.File_SellerNetwork30,"Sheet1");
String[] sStoreNumbers = new String[3];// modification to code is here.
sStoreNumbers[0] = Utility.ExcelUtils.getCellData(1, 1);
sStoreNumbers[1] = Utility.ExcelUtils.getCellData(2, 1);
sStoreNumbers[2] = Utility.ExcelUtils.getCellData(3, 1);
SellerNetworkSetupPage.txt_StoreNum(driver).sendKeys(sStoreNumbers);
SellerNetworkSetupPage.btn_Add(driver).click();

if (Count ==10) {
break;}