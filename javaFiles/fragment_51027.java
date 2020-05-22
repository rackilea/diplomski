public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;

        String[] a1 = s1.split("_");
        String[] a2 = s2.split("_");

         /* If the primary elements of order are equal the result is 
         the order of the second elements of order */ 
        if (a1[1].compareTo(a2[1]) == 0) { 
            return a1[2].compareTo(a2[2]); 
        /* If they are not equal, we just order by the primary elements */
        } else {
            return a1[1].compareTo(a2[1]);
        }
    }