Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }
    };

    Iterator<String> iterate = map.keySet().iterator();

    while  (iterate.hasNext()) {
        int i = map.get(iterate.next());

        if(i > 1) {
            iterate.remove();
        }
    }

    System.out.println(map);