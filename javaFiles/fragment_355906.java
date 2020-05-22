public static void main(String[] args) {
    // array for second file
    for (int n = 0; n < nums1.size(); n++) {

        // matches are false by default

        int count = 0;

            String v = nums1.get(n);

        // array for first file
        for (int k = 0; k < nums.size(); k++) {

            String p = nums.get(k);

            // second file contains values from first file
            if (p==v) {

                count++;

                }


            }
        System.out.println( v + " " + "is duped" + " " + count + " " + "times");

        }

    }

}