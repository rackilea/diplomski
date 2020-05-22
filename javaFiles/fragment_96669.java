private final Executor executor = Executors.newSingleThreadExecutor();

 ...

 executor.execute(() -> {
     try(Realm realm = Realm.getDefaultInstance()) {
         // use Realm on background thread
     }
 });