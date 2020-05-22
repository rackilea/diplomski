int n = 7;

// make a list of n unique random numbers 
double[] randomValues = new Random().doubles(0, 1).distinct().limit(n).toArray();

// normalize the list and reverse sort it
double sum = Arrays.stream(randomValues).sum();
List<Double> array = Arrays.stream(randomValues).boxed()
        .map(d -> d/sum)
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());