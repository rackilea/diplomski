class GpaComparator implements Comparator< Student> {
    @Override public int compare(Student left, Student right) {
        if (left.getGpa() < right.getGpa()) {
            return -1;
       } else if (left.getGpa() > right.getGpa()) {
            return 1;
       } else {
           return 0;
     }
 }