JavaPairDstream<String,String[]> singleLineDStream = pairdDstream.reduceByKey(new Function2<String[],String[],String[]>(){
    @Override
    public String[] call(String[] arg0, String[] arg1) throws Exception {
        return arg0;
    }
});