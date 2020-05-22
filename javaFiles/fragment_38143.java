map1.forEach((k0, v0) -> {
    if (!map2.containsKey(k0)) {
        System.out.println(String.format("key %s in map1 missing in map2", k0));
    } else {
        v0.forEach((k1, v1) -> {
            if (!map2.get(k0).containsKey(k1)) {
                System.out.println(String.format("In %s, %s in map1 is missing in map2", k0, k1));
            } else {
                if (!v1.equals(map2.get(k0).get(k1))) {
                    System.out.println(String.format("In %s, %s=%s in map1 is not equal to %s=%s in map2", k0, k1, v1, k1, map2.get(k0).get(k1)));
                }
            }
        });
    }
});