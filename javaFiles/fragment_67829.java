List<Integer> flattenList = new ArrayList<>();
        for(List<Integer> list : m.values()){
            for(Integer i : list)
                flattenList.add(i);
        }
        System.out.println(flattenList);