public static Comparator<SortingObjects StuNameComparator = new Comparator<SortingObjects() {
    List ordering = Arrays.asList("CH","AP","TN","KE");
    public int compare(SortingObjects s1, SortingObjects s2) {                 

       return ordering.indexOf(s1.name) - ordering.indexOf(s2.name);                                                               

    }};