Arrays.stream(arr1).parallel()
    .mapToObj(i1 -> prepareOperation(i1))
    .forEach(cached ->
        Arrays.stream(arr2).forEach(i2 ->
            Arrays.stream(arr3).forEach(i3 ->
                doComputationallyIntensiveThing(cached, i2, i3))));