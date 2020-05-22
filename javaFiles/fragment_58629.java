import java.util.concurrent.CompletableFuture;
...
final CompletableFuture<String> listOfCities = CompletableFuture.supplyAsync(() -> service.getListOfCities(...));
final CompletableFuture<String> listOfCountries = CompletableFuture.supplyAsync(() -> service. getListOfCountries(...));
final CompletableFuture<Void> allCompleted = CompletableFuture.allOf(listOfCities, listOfCountries);
allCompleted.thenRun(() -> {
    // whatever you want to do 
});