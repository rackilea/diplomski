boolean condition = true;
    final String name;
    if(condition) {
        name = "Tiger";
    }else {
        name = "Oscar";
    }
    CompletableFuture.runAsync(() -> System.out.println(name));