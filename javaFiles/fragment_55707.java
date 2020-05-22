CompletableFuture<Object> subStage = new CompletableFuture<>();
try {
    templateIds.map(
        id ->
            // do something and return CompletionStage<String>
            .thenAccept(
                tree -> {
                  templateTreeHolder.set(
                      (ObjectNode)
                          templateTreeHolder.get().set(id, Json.readTree(tree)));

                  System.out.println(
                      "From inner function: " + templateTreeHolder.get());
                })
            .whenComplete((v,t) -> {
                // complete when all work has been done
                if(t != null) subStage.completeExceptionally(t);
                else subStage.complete(v);
            }));
} catch(Throwable t) {
    subStage.completeExceptionally(t);
}
// use this stage for dependent actions
return subStage;