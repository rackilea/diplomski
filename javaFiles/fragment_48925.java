List<String> testList = Arrays.asList("abckddkd", "abdsdfwer", "acdxdf");
    Map<String, List<String>> resultMap = testList.stream().filter(line -> line.length() > 3)
            .collect(Collector.of(HashMap::new, (map, line) -> {
                IntStream.range(1, 4).forEach(n->{
                    if(map.get(line.substring(0, n))==null) {
                        List<String> list = new ArrayList<>();
                        list.add(line);
                        map.put(line.substring(0, n),list);
                    }else {
                        //handle duplicate here if you want
                        map.get(line.substring(0, n)).add(line);
                    }
                });
            }, (map1, map2) -> {
                throw new UnsupportedOperationException();
            }, new Characteristics[] { Characteristics.IDENTITY_FINISH }));
    System.out.println(resultMap);