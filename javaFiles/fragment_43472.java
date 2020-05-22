AsyncTaskExecutor executor = ...;
MyClass theService = ...;
String foo = "apple", bar = "banana";
Future<Results> result = executor.submit(new Callable<Results>(){
    @Override public Results call(){
        return theService.process(foo, bar);
    }
});
// Or if you're on Java 8:
Future<Results> result = executor.submit(() -> theService.process(foo, bar);