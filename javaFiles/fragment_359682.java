Map<Integer, List<Term>> collect = list
                .stream()
                .collect(Collectors.groupingBy(Abc::getRowNum))
                .entrySet()
                .stream()
                .filter(v-> v.getValue().size()>=2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));