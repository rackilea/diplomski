for(int i=0; i<array.length(); i++) {
        JSONObject obj = array.getJSONObject(i);

        JSONArray ar = obj.getJSONArray("coordinates");

        for(int j=0; j<ar.length(); j++) {
            String co = ar.getString(i);
            System.out.println(co);
        }
    }