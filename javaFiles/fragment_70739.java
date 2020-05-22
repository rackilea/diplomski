static List<Integer> getMissingNo(int[] a, int n) {

        List<Integer> listOfDistinctElements = Arrays.stream(a)
                .boxed()
                .distinct().collect(Collectors.toList());

        List<Integer> elemntsLeftOut = new ArrayList<>();

        IntStream.range(1, listOfDistinctElements.get(listOfDistinctElements.size()-1)).forEach(index ->
                        {
                            if(!listOfDistinctElements.contains(index)){
                                 elemntsLeftOut.add(index);
                        }
                    });

        return elemntsLeftOut;
        }