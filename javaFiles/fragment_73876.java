Map<Boolean,Integer> partitionSums =
    IntStream.range(0,nums.size()-1)
             .map(i -> nums.get(i) - nums.get(i+1))
            .boxed()
            .collect(Collectors.partitioningBy (i -> i >= 0,
                                                Collectors.summingInt (Integer::intValue)));