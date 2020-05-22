public static List<Integer> execSort(List<Integer> s) {

    int start = (s.size()/2)-1;
    int end = s.size()-1;

    while( start >= 0){
        s = sift(s, start, end);