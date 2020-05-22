public IndexRequestBuilder setIndex(String data,String IndexName){
    try{
        return client.prepareIndex(IndexName, "event").setSource(data);
    }catch(Exception e){
        e.printStackTrace();
    }
    return null;
}