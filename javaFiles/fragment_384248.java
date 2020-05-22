...
try{
    driver.navigate().to(url);

}catch(Exception e){
    System.out.println("Error in driver " + e.getMessage().toString());
    return result;
}
//web elements
try{
    WebElement name_to_input = driver.findElement(By.id("ID1"));
    WebElement email_to_input =  driver.findElement(By.id("id2"));
    WebElement message_to_input = driver.findElement(By.id("ID3"));
}catch(NoSuchElementException MSEE){
    MSEE.printStackTrace();

} finally {
    return result;
}
...