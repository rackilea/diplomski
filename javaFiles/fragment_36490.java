public static String compareCircles(int r1, int r2) {  
       String output = "";
       if (r1 < r2)
           output = r1+" circle is smaller than "+r2;
       if (r1 == r2)
           output = "both circles are in same size.";
       if (r1 > r2)
           output = r1+" circle is larger than "+r2;
       return output;
}