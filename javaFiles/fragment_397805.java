public static String getProperties(String namespace, String value) throws ConfigLoaderException {
        String param=namespace+"."+value;

        if(!val.containsKey(param)){
            throw new ConfigLoaderException(param+" ERROR");
        }else{
            return val.get(param);

        }
    }