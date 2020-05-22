public Map<String, Object>  getMapFromIoJsonwebtokenClaims(Claims claims){
    Map<String, Object> expectedMap = new HashMap<String, Object>();
    for(Entry<String, Object> entry : claims.entrySet()) {
        expectedMap.put(entry.getKey() , entry.getValue());
    }
    return expectedMap;
}