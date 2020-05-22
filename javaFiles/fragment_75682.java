private String modifyJsonObject(String jsonString){
    String json = "{\"notSecret\": \"jetFuelCantMeltSteelBeams\",\"cid\": \"superSecret\",\"obj\": { \"cid\": \"moreSecret\" },\"objObj\": { \"child\": { \"cid\": \"itsASecretToEverybody\" } },\"array\": [1, 2, 3],\"objArr\": [{ \"cid\": \"topSecret\" }, { \"cid\": \"iCantBelieveItsSecret\" }], \"arrArr\": [[1, 2], [1, 2]],\"mixed\": [{ \"name\": \"Waldo\" },{ \"cid\": \"unbelievablySecret\" },7,[{ \"name\": \"HeisenBurg\" }, 9]],\"emptyObj\": {},\"emptyArr\": []}";
    try {
        JSONObject jObject  = new JSONObject(json);
        modJO(jObject);
        return jObject.toString();
    }
    catch(Exception ex){
        int stop  = 4;
    }
    return "";
}