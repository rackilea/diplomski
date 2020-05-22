try{
    if(javaMailAPI.send()){
        // Do something on success
    }
    else{
        // Do something on fail
    }
}
catch(UnknownHostException ex){
    // Do something when I have no Internet Connection
}
catch(Exception ex){
    // Do something else when I have an other Exception
}