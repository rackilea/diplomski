dataStr = "[{\"DIMNAME\": \"d11\",\"DIMID\": 11}, {\"DIMNAME\": \"d12\",\"DIMID\": 12}]";
JSONArray cadDims;
try {
    cadDims = new JSONArray(dataStr);
} catch (JSONException ex) {
    Logger.getLogger(EnCad.class.getName()).log(Level.SEVERE, null, ex);
}
if(cadDims != null){
    //Do something with cadDims
}