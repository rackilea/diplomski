Collector<Integer, List<Integer>, List<Integer>> myCollector = 
        Collector.of(ArrayList<Integer>::new, 
                (list, element) -> {list.add(element);}, 
                (list1, list2) -> {list1.addAll(list2); return list1;}, 
                                                    //  -------------   added 
                Function.identity(), 
                Characteristics.values()
                );