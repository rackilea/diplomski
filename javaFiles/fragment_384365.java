CachedIntegerAggregator aggregator = new CachedIntegerAggregator(2, 3, 4);

// hm, what is the sum?
System.out.println(aggregator.getSum());

// let's print of integers
List<Integer> integers = aggregator.getIntegers();
System.out.println(integers);

// now, see the double
int size = integers.size();
for (int i = 0; i < size; i++) { // (oops! this changes internal data!)
    integers.set(i, integers.get(i) * 2);
}
System.out.println(integers);

// hm, see sum and multi
System.out.println(aggregator.getSum());
System.out.println(aggregator.getMulti()); // (oops! total inconsistency!)