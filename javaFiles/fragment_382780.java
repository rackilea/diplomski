Multimap<Integer,DatedObject> mmap = Multimaps.index(
        masterList,
        new Function<DatedObject, Integer>(){
            @Override public Integer apply(DatedObject from) {
                return from.year;
            }
        }
    );
    System.out.println(mmap);
    // prints "{2010=[A (2010), D (2010)], 2009=[B (2009), E (2009)],
    //          2006=[C (2006)], 2011=[F (2011)]}"