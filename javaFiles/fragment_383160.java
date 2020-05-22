private String resolveExceptionToMessage(Exception exceptio){
    //or put in map<Exceptio,String error.message.type1> 
    // String errorCode = map.get(excptio);
    //eturn messageSource.getMessage(errorCode , new Object[]{},locale);
    if(exceptio instanceof ....){
        return messageSource.getMessage("error.message.type1", new Object[]{},locale);
    }
    return "";
}