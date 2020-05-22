@FindBy(xpath = "//*[contains(@id,'(element(')]")
public List<WebElement> fields;


Then read the each values in the similar elements one by one

public void getElementText(){
      for (WebElement objElement : fields) {
        System.out.println(objElement.getText());
    }
}