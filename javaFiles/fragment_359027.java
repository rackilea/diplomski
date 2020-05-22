for (String s1 : map.keySet()) {
        if (map.get(s1).equals(biggest))
            list.add(0, s1);
        else if (map.get(s1).equals(secondBiggest))
            list.add(s1);
    }