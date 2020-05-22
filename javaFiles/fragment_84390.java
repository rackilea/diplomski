class RequestFlags{
    int requestCount;
    Params params;
};
private final RequestFlags requestFlags;

public requestWrapper(RequestFlags rf){
    VKRequestListener listener = new VKRequestListener(){
        @Override
        public void onComplete(VKResponse response){
        // do smth when response is complete
             if(requestFlags.requestCount != 0) {
                 requestFlags.requestCount--;
                 requestFlags.params = doSmth(response);
                 requestWrapper(requestFlags);
             } else{
                 // we finished - do smth on finish
             }
        }
    }
    Params someParams;
    switch(requestFlags.params){
        case param1: someParams = doSmthElse();
        break;
        case param2: someParams = null;
        break;
        // etc, etc...
    }
    VKRequest vkRequest = new VKRequest("request", someParams);
    vkRequest.executeWithListener(listener);        
}