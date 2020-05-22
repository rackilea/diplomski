public void login_Doc(String uid,String pas,boolean isValidCredential)
{
    username.sendKeys(uid);
    password.sendKeys(pas);
    button.click();
    if(isValidCredential == true){
      // check if user is logged in successfully and click on logout button
   } else {
      //check appropriate error message is displayed
    }
}