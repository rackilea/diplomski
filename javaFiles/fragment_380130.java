HashMap<String,List<String>> hashMap = new HashMap<>();

    hashMap.put("k1", Arrays.asList("v1","v2"));
    hashMap.put("k2", Arrays.asList("v2"));
    hashMap.put("k3", Arrays.asList("v1"));

    HashMap<String,List<String>> result = new HashMap<>();

    hashMap.forEach((s, strings) ->{
        for (String element : strings){
            List<String> tempList = new ArrayList<>();

            if(result.containsKey(element)){
                tempList = result.get(element);
            }

            tempList.add(s);
            result.put(element, tempList);
        }
    });