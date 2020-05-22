try{
    //your code here
}
catch (Exception ex){
    log.warn("Error in my script", ex);
    throw ex; // elsewise JMeter will "swallow" the above exception
}