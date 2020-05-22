public static void main(String[] args) {
        int[] array1 = new int[] { 1, 2, 3 };
        int[] array2 = new int[] { 1, 2, 3 }; // array1 = array2
        int[] array3 = new int[] { 0, 2, 3 };

        List<List<Integer>> test = new ArrayList<>();

        test.add(Arrays.stream(array1)
                       .boxed()
                       .collect(Collectors.toList()));
        test.add(Arrays.stream(array2)
                       .boxed()
                       .collect(Collectors.toList()));
        test.add(Arrays.stream(array3)
                       .boxed()
                       .collect(Collectors.toList()));

        Map<List<Integer>, Long> map = test.stream()
                                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);    
    }