try {
    for(...){
        try{
            ...
        }catch(...){
            ...
        }finally{
            try{
                if(fsdisPath!=null){
                    fsdisPath.close();
                }
            }catch(Exceptionex){
                ex.printStackTrace();
            }
        }
    }
} finally {
    if(client!=null){
        client.disconnect();
    }
}