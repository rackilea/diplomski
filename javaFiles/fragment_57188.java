class RequestDeserializer implements JsonDeserializer<Request> {

    JsonElement element = null ;
    JsonElement argumentJson = null ;
    Class<?> types = null ;

    public RequestDeserializer(Class<?> tps){
        types = tps ;
    }

    public Object[] getArguments(){

        if (types.length == 0)
            return null ;

        Object[] arguments = new Object[types.length] ;

        if (argumentJson != null && argumentJson.isJsonArray()){

            JsonArray array = argumentJson.getAsJsonArray() ;

            for ( int i=0 ; i < types.length ; i++){

                JsonElement arrayEle = array.get(i) ;

                Gson gson = new Gson() ;

                arguments[i] = gson.fromJson(arrayEle, types[i]) ;
            }
        }
        return arguments;
    }
}