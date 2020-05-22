static <T> Collector<T,?,List<T>> toSortedList(Comparator<? super T> c) {
    return Collector.of(ArrayList::new,
        (l,t) -> {
            int ix=Collections.binarySearch(l, t, c);
            l.add(ix<0? ~ix: ix, t);
        },
        (list1,list2) -> {
            final int s1=list1.size();
            if(list1.isEmpty()) return list2;
            if(!list2.isEmpty()) {
                list1.addAll(list2);
                if(c.compare(list1.get(s1-1), list2.get(0))>0)
                    list1.sort(c);
            }
            return list1;
        });
}