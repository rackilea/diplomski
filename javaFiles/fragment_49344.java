String result;
    try {
        result = future.get(2, TimeUnit.SECONDS);
        System.out.println("future result:" + result);
    } catch (TimeoutException e) {
        System.out.println("timeout exception");
        result = "hello";
    } finally {