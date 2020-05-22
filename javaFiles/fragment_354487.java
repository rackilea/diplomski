future
        .handleAsync((object, throwable) -> {
            if (throwable !=null) {
                    System.out.println("EXCEPTION from future completion: " + throwable.getClass().getName());
                return null;
            }
            else {
                throw new IllegalStateException("async processing failed");
            }
        })
        .exceptionally(throwable -> {
                System.out.println("EXCEPTION from completion stage: " + throwable.getClass().getName());
            return null;
        });