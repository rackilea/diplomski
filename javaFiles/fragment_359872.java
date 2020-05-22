Double min = Collections.min(arrayOfInts);
Double max = Collections.max(arrayOfInts);
arrayOfInts.remove(min);
if (min != max)
    arrayOfInts.remove(max);

List<Double> minMaxList = new ArrayList<>(Arrays.asList(min, max));