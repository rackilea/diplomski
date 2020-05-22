public static int[] getPositiveNumbers(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for(int n : numbers) {
            if (n > 0) {
                result.add(n);
            }
        }
        int[] array = new int[result.size()];
        for(int i = 0; i < result.size(); i++) array[i] = result.get(i);

        return array;
    }