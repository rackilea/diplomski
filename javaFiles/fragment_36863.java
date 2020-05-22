Map<String, Integer> map = new HashMap<String, Integer>();
        for(Custom custom : customList)
        {
            if(map.containsKey(custom.getCat_name()))
            {
                Integer i = map.get(custom.getCat_name());
                map.put(custom.getCat_name(), i+custom.getTotal());
            }
            else
            {
                map.put(custom.getCat_name(), custom.getTotal());
            }
        }

        System.out.println("Map : "+map);