if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
   mockLocation.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
   // Elapsed time can also be set using
   // mockLocation.setElapsedRealtimeNanos(System.nanoTime());
   // Elapsed time can be disregarded using
   // mockLocation.makeComplete();
}