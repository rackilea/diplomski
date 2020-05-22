HashMap<String,String> map = 
        new HashMap<String, String>(IntStream
                                    .range(0,values[0].length)
                                    .boxed()
                                    .collect(Collectors.
                                             toMap(i -> values[0][i], i -> values[1][i])));