runnables
    .reduce((r1, r2) -> () -> { 
         r1.run(); 
         runnable.run();
         r2.run(); 
    })
    .orElse(() -> {})
    .run();