String s = Integer.toBinaryString(N);
int maxDiff = IntStream.range(0, s.length())
    .filter(i -> s.charAt(i) == '1')
    .collect(
        // supply a new list to hold intermediate results
        () -> {
            List<Integer> acc = new ArrayList<Integer>();
            acc.add(0); // initial max diff; and result if no "gap" exists
            return acc;
        },
        // accumulate one more number into the result
        (List<Integer> list, int num) -> {
            if(list.size() == 1) {
                // this is the first number, no diffs yet
                list.add(num);
            } else {
                int max = list.get(0);
                int lastNum = list.get(1);
                int diff = num - lastNum;
                list.set(0, diff > max ? diff : max);
                list.set(1, num);
            }
        },
        // combine two accummulators; shouldn't be called
        (List<Integer> list1, List<Integer> list2) -> {
            throw new RuntimeException("combiner shouldn't be called");
        }
    )
    .get(0); // max diff is at index 0 in the list