Collections.sort( jsonList, new Comparator<JSONObject>() {

    public int compare(JSONObject a, JSONObject b) {
        String valA = new String();
        String valB = new String();

        try {
            valA = (String) a.get("distance");
            valB = (String) b.get("distance");
        } 
        catch (JSONException e) {
            //do something
        }

        return valA.compareTo(valB);
    }
});