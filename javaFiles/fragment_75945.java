int[] arr = new int[]{5,20 ,1 ,12};
IntStream.range(0, arr.length)
         .mapToObj(index -> new SimpleEntry<>(index, arr[index]))
         .min(Comparator.comparingInt(SimpleEntry::getValue))
         .ifPresent(s -> System.out.println(s.getValue()+ 
               " is the smallest number and it's index" + s.getKey() + "of array"));