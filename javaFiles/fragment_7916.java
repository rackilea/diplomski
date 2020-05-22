int[] output = new int[input.length];
Map<Integer,Integer> counts = new HashMap<>();
int size = 0;
for (int i = 0; i < input.length; i++) {
    counts.put(input[i], counts.getOrDefault(input[i], 0) + 1);
}
for (int i = 0; i < input.length; i++) {
    if (counts.get(input[i]) < n)
        output[size++] = input[i];
}
return Arrays.copyOf(output, size);