final SortedSet<myData> sorted = new TreeSet<>(new Comparator<myData>() {
            @Override
            public int compare(myData o1, myData o2) {
                 int comparedValue = o1.expDtTm.compareTo(o2.expDtTm);
                 if(comparedValue == 0){
                       comparedValue = 1;
                 }
            }
});