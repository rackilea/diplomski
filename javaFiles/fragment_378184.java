ListTSeq<Integer> listT = ReactiveSeq.of(1,2,3,4,5, 6)
                                     .map(n-> n==6? sleep(1) : n)
                                     .groupedT(4);

ReactiveSeq<ListX<Integer>> nested = listT.toNestedListX()
                                          .stream();