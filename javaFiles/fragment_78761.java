List<Integer> list=Arrays.asList(1, 2, 3, 4, 5, 6, 7);
int listSize=list.size(), chunkSize=2;
List<List<Integer>> list2=
    IntStream.range(0, (listSize-1)/chunkSize+1)
             .mapToObj(i->list.subList(i*=chunkSize,
                                       listSize-chunkSize>=i? i+chunkSize: listSize))
             .collect(Collectors.toList());