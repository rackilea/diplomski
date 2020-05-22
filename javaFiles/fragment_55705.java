return getTemplateIds(context, metricsClient, jdbcSession, content)
    .thenCompose(
        templateIds -> {
          // create an initially uncompleted stage
          CompletableFuture<Object> subStage = new CompletableFuture<>(); 
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
                            // complete when all work has been done
                            subStage.complete(null);
                          }));
          // use this stage for dependent actions
          return subStage;
        })
    .thenApply(
        notUsed -> {
          String includedTemplateIdsStr =
              getKeysFromTemplateTree(templateTreeHolder.get()).toJavaList().toString();

          System.out.println("From outer function: " + templateTreeHolder.get());

          return Tuple.of(templateTreeHolder.get(), includedTemplateIdsStr);
        });