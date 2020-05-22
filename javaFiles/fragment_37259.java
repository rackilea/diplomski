public static int sumInts(int begin, int end){
    if (begin == end)
        return begin;
    else
        return end + sumInts(begin,end-1);
}