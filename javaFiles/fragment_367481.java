List<WebElement> phone_feature_list = driver.findElements(By.xpath("//table[@id='ContentHolder_lbFeatures_LBT']/tbody/tr/td[contains(@class, 'dxeT')]"));
int size = phone_feature_list.size();

// choose an option from the dropdown

// wait for the size to change
while ((phone_feature_list = driver.findElements(By.xpath("//table[@id='ContentHolder_lbFeatures_LBT']/tbody/tr/td[contains(@class, 'dxeT')]"))).size() == size);

System.out.println("Number of Elements : " + phone_feature_list.size());