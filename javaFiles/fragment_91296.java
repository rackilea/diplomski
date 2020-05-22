if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
     new Update().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
     new Validate().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
     new Enter().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
}
 else {
     new Update().execute();
     new Validate().execute();
     new Enter().execute();
}