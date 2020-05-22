public void verifyWizardMessage(String message) throws AssertionError{
    try{
       bot.text(" "+message);
    }catch(WidgetNotFoundException e){
        throw (new AssertionError("no matching message found"));
    }
}