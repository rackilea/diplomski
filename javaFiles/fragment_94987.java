//current first page
  String firstPageTitle = driver.getTitle();
  String txt1=element1.getText();
  element1.click();

  //current page Second
  String secondPageTitle = driver.getTitle();

  if(!secondPageTitle.equals(firstPageTitle )){
  String txt2=element2.getText();
  }
  //verify if element texts are equal
  if(txt1.equals(txt2))
  {
  System.out.println("Success");
  }
  else
  {
  System.out.println("Failure");
  }