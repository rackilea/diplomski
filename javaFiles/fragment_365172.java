public static int getSum(int n) {
     int s = getSumHelper(n); // your original (private) method
     while (s > 9)
         s = getSumHelper(s);
     return s;
}