String nums = "001203";

    List<Integer> list = new ArrayList<>();

    // a boolean flag to help check for leading zeroes
    // set it to true first i.e. assume there are leading zeroes
    boolean checkLeadingZeroes = true;

    // Ignore leading zeroes during iteration,
    // and append to list in reverse order

    for (int i=0; i < nums.length(); i++){
        int n = Integer.parseInt(nums.charAt(i)+"");

        // only check for leading zeroes if flag is true

        if (checkLeadingZeroes){
            // If flag is set to false here, you've found the first non-zero

            checkLeadingZeroes = (n == 0);
        }

        if (!checkLeadingZeroes) {
            /* If flag is false, n is not a leading zero
             * Add n to the beginning of your list (index 0)
             */
            list.add(0, n);
        }
    }