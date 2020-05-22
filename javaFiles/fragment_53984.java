Map<FoodsDto, List<FoodsDto>> map = new HashMap<>();        

    for(FoodsDto o : developmentResult){
        // using the FoodsDto as the key
        if (map.get(o) != null) {
            map.get(o).add(o);
        } else {
            List<FoodsDto> foodList = new ArrayList<FoodsDto>();
            foodList.add(o);
            map.put(o, foodList);
        }
    }

    for (Map.Entry<FoodsDto, List<FoodsDto>> entry : map.entrySet()) {
        List<FoodsDto> list = entry.getValue();
        System.out.println(String.format("%s: %d", entry.getKey(), list.size()));

        for(FoodsDto f : list){
            System.out.println(f);
        }
    }