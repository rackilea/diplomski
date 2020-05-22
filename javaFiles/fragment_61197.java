Gson gson = new Gson();
        Object o = gson.fromJson(str, Object.class);
        List keys = new ArrayList();
        Collection values = null;
        if (o instanceof Map) {
            Map map = (Map) o;
            keys.addAll(map.keySet()); // collect keys at current level in hierarchy
            values = map.values();
        } else if (o instanceof Collection) {
            values = (Collection) o;
        }
        System.out.println(keys);// [CDG, ORY, LBG]
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i));
        }