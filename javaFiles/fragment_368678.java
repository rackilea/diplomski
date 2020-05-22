List<Pair<Long, Long>> result = 
    myLongsList.stream()
               .flatMap(firstLong -> myLongsList.stream()
                                                .filter(secondLong -> !Objects.equals(firstLong, secondLong))
                                                .map(secondLong-> Pair.of(firstLong, secondLong)))
               .collect(toList());