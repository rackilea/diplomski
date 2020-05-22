static void permute(List<Character> arr, int k,List<List<Character>> results) {
 for (int i = k; i < arr.size(); i++) {
    java.util.Collections.swap(arr, i, k);
    permute(arr, k + 1, results);
    java.util.Collections.swap(arr, k, i);
 }
 if (k == arr.size() - 1) {
   results.add(new ArrayList<>(arr));
 }
}