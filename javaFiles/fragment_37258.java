public static int sumInts(int begin, int end){
    if (begin == end)
        return end; // return the last number
    else
        return begin + sumInts(begin+1,end); // sum the current number with the recursion result
}