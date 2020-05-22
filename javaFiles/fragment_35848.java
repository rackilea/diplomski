JSONObject obj = new JSONObject(inputString);

        JSONArray arr = obj.getJSONArray("links");
        for (int i = 0; i < arr.length(); i++) {
            System.out.println(arr.getString(i));
            JSONArray arr2 =arr.getJSONArray(i);
            for (int j = 0; j < arr2.length(); j++) {
                System.out.println(arr2.getString(j));
            }
            String s1 = arr2.getString(0);
            System.out.println(s1);
            JSONObject obj2 =arr2.getJSONObject(1);
            String s2 = obj2.getString("label");
            System.out.println(s2);
            String s3 = obj2.getString("currency");
            System.out.println(s3);
        }