public static String gettext(WebElement webElement){
   String Value = null;
try{ 
    Value = webElement.getText();
    APP_LOGS.debug("Got Text: "+Value); 
    return Value;
   }catch(Throwable e){
     //Catch body
    } 
 }