IntStream.range(0, n).mapToObj(
   i -> {
     long[] arr = new long[k];
     for (int j = 0; j < k; j++) {
       arr[j] = BitTools.toSortableLong(data[k * i + j]);
     }
     return arr;
   });