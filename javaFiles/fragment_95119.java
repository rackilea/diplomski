import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Main {

    public static void main(String[] args) {
        methodThatReturnsCompletionStage()
                .handle((result, error) -> {
                    if (error != null) {
                        return CompletableFuture.<String>failedStage(error);
                    } else {
                        return processResult(result);
                    }
                })
                .thenCompose(future -> {
                    System.out.println("#thenCompose invoked");
                    return future; // Identity function
                })
                .thenApply(result -> {
                    System.out.println("#thenApply invoked");
                    return result; // Identity function (exists to show intermediary stage)
                })
                .whenComplete((result, error) -> {
                    System.out.println("#whenComplete invoked");
                    if (error != null) {
                        error.printStackTrace(System.out);
                    } else {
                        System.out.println(result);
                    };
                });
    }

    private static CompletionStage<String> methodThatReturnsCompletionStage() {
        return CompletableFuture.completedStage("Hello");
        // return CompletableFuture.failedStage(new RuntimeException("OOPS"));
    }

    private static CompletionStage<String> processResult(String result) {
        return CompletableFuture.completedFuture(result + ", World!");
    }

}