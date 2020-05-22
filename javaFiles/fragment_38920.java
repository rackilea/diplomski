private static void binarySort(Object[] a, int lo, int hi, int start) {
 214         assert lo <= start && start <= hi;
 215         if (start == lo)
 216             start++;
 217         for ( ; start < hi; start++) {
 218             @SuppressWarnings("unchecked")
 219             Comparable<Object> pivot = (Comparable) a[start];
 220 
 221             // Set left (and right) to the index where a[start] (pivot) belongs
 222             int left = lo;
 223             int right = start;
 224             assert left <= right;
 225             /*
 226              * Invariants:
 227              *   pivot >= all in [lo, left).
 228              *   pivot <  all in [right, start).
 229              */
 230             while (left < right) {
 231                 int mid = (left + right) >>> 1;
 232                 if (pivot.compareTo(a[mid]) < 0)
 233                     right = mid;
 234                 else
 235                     left = mid + 1;
 236             }
 237             assert left == right;
 238