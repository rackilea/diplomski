for (int i = 0; i < getArray.length(); i++) {
        JSONObject objects = getArray.getJSONObject(i);
        Iterator key = objects.keys();
        while (key.hasNext()) {
            String k = key.next().toString();
            System.out.println("Key : " + k + ", value : "
                    + objects.getString(k));
        }
        // System.out.println(objects.toString());
        System.out.println("-----------");

    }