String microservice = "account";

    String[] scopesJWT = {"servicegroup_4", "servicegroup_5"};

    // Store all the keys in HashSet
    Set<T> keysSet = new HashSet<T>(Arrays.asList(scopesJWT));

     JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject) parser.parse(new FileReader("C:\\Users\\r.spampinato\\Desktop\\test.json"));
    JSONArray paths = (JSONArray) json.get("path");
    Iterator<JSONObject> itPath = paths.iterator();
    while (itPath.hasNext()) {
        JSONObject el = itPath.next();
        String name = el.get("name").toString();

        JSONArray scopes = (JSONArray) el.get("scopes");

        if (name.contains(microservice)) {
            boolean ok = true;
            for (String element : scopesJWT) {
                    if (keysSet.contains(element)) {
                        continue;
                    } else {
                        ok = false; break;
                    }
                }
         ok == false? System.out.println("KO") : System.out.println("OK");
        }