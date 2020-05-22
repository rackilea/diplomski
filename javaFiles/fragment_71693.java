int[] arr = new int[results.size()];
int i = 0;
for (String s : results)
    arr[i++] = Integer.parseInt(s);
Arrays.sort(arr);
results.clear();
for (int v : arr)
    results.add(Integer.toString(v));