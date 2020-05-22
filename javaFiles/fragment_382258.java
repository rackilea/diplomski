public void selectRadio(String airlineName){
  for(WebElement radio : radioButtons){
    if(radio.getAttribute("value").contains(airlineName)
        radio.click();
  }
}