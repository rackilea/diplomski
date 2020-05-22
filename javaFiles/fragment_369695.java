public void login(){
     String url="URL"
     driver.get(url);
     WebElement username= driver.findElement(By.name("username"));
     WebElement password= driver.findElement(By.name("password"));
     WebElement loginButton= driver.findElement(By.name("login_button_id"));
     Boolean isLogged=isSuccessFullyLogged(username,password,loginButton)

     if(!isLogged){
             //we need verification
     }
}

public boolean isLoggedSuccessfully(WebElement usr,WebElement psswd,WebElement button){
     if(usr!= null && psswd != null && button != null){
          usr.sendKeys("Blala");
          psswd.sendKeys("Blalaspasswd");
          button.submit();
          //We wait 10 sec to Welcome page appears on screen if it does not appear then  we need verification
          return (new WebDriverWait(driver, 10)).until(new         ExpectedCondition<Boolean>() {
                 public Boolean apply(WebDriver d) {
                       return d.getTitle().toLowerCase().startsWith("welcome!");

          });
     }      
}