public static List<Integer> findConsequtive3(ArrayList<Integer> int_values) {

        Integer[] arrayItems = (Integer[]) int_values.toArray(new Integer[0]);

        List<Integer> consequetive = new ArrayList<Integer>();
        int count = 1;
        for (int i = 1; i < arrayItems.length; i++) {
            if (arrayItems[i - 1] == arrayItems[i]) {
                count++;
                if (count == 3) {
                    consequetive.add(i + 1); // Since array is zero indexed adding 1
                    count = 0; // resetting count
                }
            }
        }
        return consequetive;
    }