long count = 0L;
long limit = 2;
Set<Integer> uniqueValues = new HashSet<>();
for (int i : new int[]{1, 2, 3}) {
    if (uniqueValues.add(i)) {
        if (limit-- == 0) break;
        count++;
    }
}
System.out.println(count);