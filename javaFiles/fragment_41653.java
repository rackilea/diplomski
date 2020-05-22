try{
    if(javaMailAPI.send()){
        // Do something on success
    }
    else{
        // Do something on fail
    }
}
catch(UnknownHostException ex){
    onNoConnection();
}
catch(Exception ex){
    // Check if the thrown Exception is a MessagingException with a nested UnknownHostException
    if(ex instanceof MessagingException){
        if(((MessagingException)ex).getNextException() instanceof UnknownHostException){
            onNoConnection();
        }
    }
    else{
        // Do something else when I have an other Exception
    }
}

private void onNoConnection(){
    // Do something when I have no Internet Connection
}