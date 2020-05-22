public static void main(String[] args) throws JSONException {
        List<String> addrList = new ArrayList<>();
        // json is the String representing the input json
        JSONObject jsonObj = new JSONObject(json);
        JSONArray blocks = jsonObj.getJSONArray("blocks");
        for (int i = 0; i < blocks.length(); i++) {
            JSONObject block = blocks.getJSONObject(i);
            JSONArray tx = block.getJSONArray("tx");
            for (int j = 0; j < tx.length(); j++) {
                JSONObject txItem = tx.getJSONObject(j);
                JSONArray out = txItem.getJSONArray("out");
                for (int k = 0; k < out.length(); k++) {
                    JSONObject outItem = out.getJSONObject(k);
                    if (outItem.has("addr")) {
                        addrList.add(outItem.getString("addr"));
                    }
                }
            }
        }
        addrList.forEach(item -> System.out.println(item));
    }