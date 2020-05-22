JSONObject jsonObject = new JSONObject(str);
        String[] names = jsonObject.getNames(jsonObject);
        for (int i = 0; i < names.length; i++) {

            System.out.println(names[i]);// all names are printed here : LBG,ORY, etc

            // then parsing the names accordingly..
            JSONObject jsonObject1 = jsonObject.getJSONObject(names[i]);
            System.out.println(jsonObject1.getString("city"));
        }