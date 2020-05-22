if( insSort.isEnabled()) {
   long startTime = System.currentTimeMillis();
   insSort(A);
   long endTime = System.currentTimeMillis();
   totalRuntime += (endTime - startTime); // this is certainly > 1
}
series.add(totalRuntime,A.length);
dataset.addSeries(series);