private static JsonObject result = new JsonObject();
private static boolean readyToGo;
    static {       
        retriever.getConfig(ar -> {
           ....
            if (ar.failed()) {
             ...
            } else {
                result.mergeIn(ar.result());
                ConfigFactory.readyToGo=true; //Now we are good to go
            }
        });
    }