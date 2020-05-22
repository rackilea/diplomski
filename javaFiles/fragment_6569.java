for(...){
    try{
        ...
    }catch(...){
        ...
    }finally{
        # this finally block is inside your for loop
        # finally block is always called whether an exception occur or not
        # on the first iteration, this is called and close your client
        try{
            if(client!=null){
                # nope, it will close the client for next iteration!
                client.disconnect();
            }if(fsdisPath!=null){
                # good to close this however
                fsdisPath.close();
            }
        }catch(Exceptionex){
            ex.printStackTrace();
        }
    }
}