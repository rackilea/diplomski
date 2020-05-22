// O(n)
Map<Integer, Integer> intToIndex = new HashMap<>();
for(int i = 0; i < arr.length; i++)
    intToIndex.put(arr[i], i);

// O(n)
for(int i = 0; i < arr.length; i++) {
    int numberToLookFor = N - arr[i];
    Integer k = intToIndex.get(numberToLookFor);
    if (k != null) {
        assert arr[i] + arr[k] == N;
        // do something with i and k
    }
}