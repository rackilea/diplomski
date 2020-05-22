public static String intToString(int number, int groupSize) {

    StringBuilder result = new StringBuilder();

    for(int i = 11; i >= 0 ; i--) {

        int mask = 1 << i;

        result.append((number & mask) != 0 ? "1" : "0");

        if (i % groupSize == 0)

            result.append('\n');
    }

    result.replace(result.length() - 1, result.length(), "");

    return result.toString();
}


public static List<int[]> get_Combination_list() {

    List<int[]>  combinations_with_int_array = new ArrayList<int[]>();

    for(int i=0;i<=4095;i++) {

        String checkbox_combination =intToString(i,12);

        int[] single_combination = new int[12];

        for (int j=0;j<=11;j++) {

            if(j<11)
            {

                single_combination[j]=Integer.parseInt(checkbox_combination.substring(j, j+1));

            }
            else
            {
                single_combination[j]=Integer.parseInt(checkbox_combination.substring(j));

            }
        }
        combinations_with_int_array.add(single_combination);

    }

    System.out.println("No of combinations : "+combinations_with_int_array.size());

    return combinations_with_int_array;
}