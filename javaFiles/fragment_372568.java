public boolean processSqlInjectQueries(List<Map<String,String> injectQueries) throws Exception {
    for(Map<String,String> q : injectQueries) {
        // do stuff with q
    }

    if(errorConditionOccurs) {
       throw new Exception();
    }
}